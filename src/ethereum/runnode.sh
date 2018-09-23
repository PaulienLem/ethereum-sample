#!/bin/bash
NODE_NAME=$1
NODE_NAME=${NODE_NAME:-"node1"}
CONTAINER_NAME="ethereum-$NODE_NAME"
DATA_ROOT=${DATA_ROOT:-"$(pwd)/.ether-$NODE_NAME"}
DATA_HASH=${DATA_HASH:-"$(pwd)/.ethash"}
docker stop $CONTAINER_NAME
docker rm $CONTAINER_NAME
RPC_ARG='--rpc --rpcaddr=0.0.0.0 --rpcport 8545 --rpcapi=db,eth,net,web3,personal --rpccorsdomain "*"'
RPC_PORTMAP="-p $RPC_PORT:8545"

ENODE_LINE=$(docker logs ethereum-bootnode 2>&1 | grep enode | head -n 1)
MYIP=$(docker exec ethereum-bootnode ifconfig eth0 | awk '/inet addr/{print substr($2,6)}')
ENODE_LINE=$(echo $ENODE_LINE | sed "s/127\.0\.0\.1/$MYIP/g" | sed "s/\[\:\:\]/$MYIP/g")
BOOTNODE_URL= "enode:${ENODE_LINE#*enode:}"

if [ ! -d $DATA_ROOT/keystore ]; then
    docker run --rm -v $DATA_ROOT:/root/.ethereum -v $(pwd)/genesis.json:/opt/genesis.json "ethereum/client-go:v1.8.12" init /opt/genesis.json
fi

docker run -d --name $CONTAINER_NAME \
    --network ethereum \
    -p 8545:8545 \
    -v $DATA_ROOT:/root/.ethereum \
    -v $DATA_HASH:/root/.ethash \
    -v $(pwd)/genesis.json:/opt/genesis.json \
    $RPC_PORTMAP \
    "ethereum/client-go:v1.8.12" --bootnodes=$BOOTNODE_URL --rpc --rpcaddr=0.0.0.0 --rpcport 8545 --rpcapi=db,eth,net,web3,personal --rpccorsdomain "*" --cache=512 --verbosity=4 --maxpeers=3 ${@:2}
