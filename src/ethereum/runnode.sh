#!/bin/bash
ENODE_LINE=$(docker logs ethereum-bootnode 2>&1 | grep enode | head -n 1)
MYIP=$(docker exec ethereum-bootnode ifconfig eth0 | awk '/inet addr/{print substr($2,6)}')
ENODE_LINE=$(echo $ENODE_LINE | sed "s/127\.0\.0\.1/$MYIP/g" | sed "s/\[\:\:\]/$MYIP/g")

docker run -d --name "ethereum-miner1" \
    --network ethereum -p 8545:8545 -v  ${DATA_ROOT:-"$(pwd)/.ether-miner1"}:/root/.ethereum \
    -v ${DATA_HASH:-"$(pwd)/.ethash"}:/root/.ethash \
    -v $(pwd)/genesis.json:/opt/genesis.json \
    "ethereum/client-go:v1.8.12" --bootnodes="enode:${ENODE_LINE#*enode:}" --rpc --rpcaddr=0.0.0.0 --rpcport 8545 --rpcapi=db,eth,net,web3,personal --rpccorsdomain "*" --cache=512 --verbosity=4 --mine -etherbase=${ETHERBASE:-"0x2549f66398d9b13a322ab2569ae4b5c85c2f8635"}
