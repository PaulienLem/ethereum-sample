#!/bin/bash
IMGNAME="ethereum/client-go:v1.8.12"
DATA_ROOT=${DATA_ROOT:-"$(pwd)/.ether-miner1"}
DATA_HASH=${DATA_HASH:-"$(pwd)/.ethash"}

ENODE_LINE=$(docker logs ethereum-bootnode 2>&1 | grep enode | head -n 1)
MYIP=$(docker exec ethereum-bootnode ifconfig eth0 | awk '/inet addr/{print substr($2,6)}')
ENODE_LINE=$(echo $ENODE_LINE | sed "s/127\.0\.0\.1/$MYIP/g" | sed "s/\[\:\:\]/$MYIP/g")
BOOTNODE_URL= "enode:${ENODE_LINE#*enode:}"

if [ ! -f $(pwd)/genesis.json ]; then
    GEN_ALLOC='"0x0000000000000000000000000000000000000001": {"balance": "100000"}, "0xf6165e3ab53a51e974af53b4af28e53f6dc405e2": {"balance": "100000"}'
    sed "s/\0xeddeadbabeeddead/0xeddeadbabeeddead/g" src/genesis.json.template | sed "s/\${GEN_ALLOC}/$GEN_ALLOC/g" | sed "s/\1981/1981/g" > genesis.json    exit
fi

if [ ! -d $DATA_ROOT/keystore ]; then
    docker run --rm \
        -v $DATA_ROOT:/root/.ethereum \
        -v $(pwd)/genesis.json:/opt/genesis.json \
        $IMGNAME init /opt/genesis.json
fi

docker run -d --name ethereum-miner1 \
    --network ethereum \
    -p 8545:8545 \
    -v $DATA_ROOT:/root/.ethereum \
    -v $DATA_HASH:/root/.ethash \
    -v $(pwd)/genesis.json:/opt/genesis.json \
    $IMGNAME --bootnodes=$BOOTNODE_URL --rpc --rpcaddr=0.0.0.0 --rpcport 8545 --rpcapi=db,eth,net,web3,personal --rpccorsdomain "*" --cache=512 --verbosity=4 --maxpeers=3  --mine --minerthreads=1 --etherbase="0x0000000000000000000000000000000000000001"
