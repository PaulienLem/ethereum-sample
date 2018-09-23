#!/bin/bash
ENODE_LINE=$(docker logs ethereum-bootnode 2>&1 | grep enode | head -n 1)
MYIP=$(docker exec ethereum-bootnode ifconfig eth0 | awk '/inet addr/{print substr($2,6)}')
ENODE_LINE=$(echo $ENODE_LINE | sed "s/127\.0\.0\.1/$MYIP/g" | sed "s/\[\:\:\]/$MYIP/g")
BOOTNODE_URL= "enode:${ENODE_LINE#*enode:}"

docker run -d --name "ethereum-miner1" \
    --network ethereum -p 8545:8545 -v  ${DATA_ROOT:-"$(pwd)/.ether-miner1"}:/root/.ethereum \
    -v ${DATA_HASH:-"$(pwd)/.ethash"}:/root/.ethash \
    -v $(pwd)/genesis.json:/opt/genesis.json \
    -p :8545 \
    "ethereum/client-go:v1.8.12" --bootnodes=$BOOTNODE_URL --rpc --rpcaddr=0.0.0.0 --rpcport 8545 --rpcapi=db,eth,net,web3,personal --rpccorsdomain "*" --cache=512 --verbosity=4 --maxpeers=3 --mine --minerthreads=1 --etherbase=${ETHERBASE:-"0x0000000000000000000000000000000000000001"}
