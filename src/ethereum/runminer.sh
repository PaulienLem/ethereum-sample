#!/bin/bash
docker stop ethereum-bootnode
docker rm ethereum-bootnode
DATA_ROOT=${DATA_ROOT:-$(pwd)}
mkdir -p $DATA_ROOT/.bootnode

if [ ! -f $DATA_ROOT/.bootnode/boot.key ]; then
    docker run --rm -v $DATA_ROOT/.bootnode:/opt/bootnode "ethereum/client-go:alltools-v1.8.12" bootnode --genkey /opt/bootnode/boot.key
fi

[ ! "$(docker network ls | grep ethereum)" ] && docker network create ethereum
[[ -z $BOOTNODE_SERVICE ]] && BOOTNODE_SERVICE="127.0.0.1"

docker run -d --name ethereum-bootnode \
    -v $DATA_ROOT/.bootnode:/opt/bootnode --network ethereum "ethereum/client-go:alltools-v1.8.12" bootnode --nodekey /opt/bootnode/boot.key --verbosity=3 "$@"

ETHERBASE=${ETHERBASE:-"0x0000000000000000000000000000000000000001"}
./runnode.sh "miner1" --mine --minerthreads=1 --etherbase="$ETHERBASE"
