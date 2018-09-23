#!/bin/bash
docker run -d --name "ethereum-miner1" \
    --network ethereum -p 8545:8545 -v  ${DATA_ROOT:-"$(pwd)/.ether-miner1"}:/root/.ethereum \
    -v ${DATA_HASH:-"$(pwd)/.ethash"}:/root/.ethash \
    -v $(pwd)/genesis.json:/opt/genesis.json \
    -p :8545 \
    "ethereum/client-go:v1.8.12"  --rpc --rpcaddr=0.0.0.0 --rpcport 8545 --rpcapi=db,eth,net,web3,personal --rpccorsdomain "*" --cache=512 --verbosity=4 --maxpeers=3 ${@:2}
