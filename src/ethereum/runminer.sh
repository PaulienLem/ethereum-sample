#!/bin/bash

DATA_ROOT=${DATA_ROOT:-$(pwd)}
mkdir -p $DATA_ROOT/.bootnode

docker run --rm -v $DATA_ROOT/.bootnode:/opt/bootnode "ethereum/client-go:alltools-v1.8.12" bootnode --genkey /opt/bootnode/boot.key

[ ! "$(docker network ls | grep ethereum)" ] && docker network create ethereum
[[ -z $BOOTNODE_SERVICE ]] && BOOTNODE_SERVICE="127.0.0.1"

docker run -d --name ethereum-bootnode \
    -v $DATA_ROOT/.bootnode:/opt/bootnode --network ethereum "ethereum/client-go:alltools-v1.8.12" bootnode --nodekey /opt/bootnode/boot.key --verbosity=3

./runnode.sh
