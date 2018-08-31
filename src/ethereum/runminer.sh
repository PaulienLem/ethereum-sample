#!/bin/bash

IMGNAME="ethereum/client-go:alltools-v1.8.12"

DATA_ROOT=${DATA_ROOT:-$(pwd)}
mkdir -p $DATA_ROOT/.bootnode
if [ ! -f $DATA_ROOT/.bootnode/boot.key ]; then
    echo "$DATA_ROOT/.bootnode/boot.key not found, generating..."
    docker run --rm \
        -v $DATA_ROOT/.bootnode:/opt/bootnode \
        $IMGNAME bootnode --genkey /opt/bootnode/boot.key
    echo "...done!"
fi
[ ! "$(docker network ls | grep ethereum)" ] && docker network create ethereum
[[ -z $BOOTNODE_SERVICE ]] && BOOTNODE_SERVICE="127.0.0.1"

docker run -d --name ethereum-bootnode \
    -v $DATA_ROOT/.bootnode:/opt/bootnode \
    --network ethereum \
    $IMGNAME bootnode --nodekey /opt/bootnode/boot.key --verbosity=3 "$@"

./runnode.sh

docker exec -ti "ethereum-miner1" sh -c "geth attach && "
docker exec -ti "ethereum-miner1" geth --exec 'miner.setEtherbase(eth.accounts[0])'