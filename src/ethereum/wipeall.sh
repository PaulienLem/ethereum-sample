#!/bin/bash
DATA_ROOT=${DATA_ROOT:-$(pwd)}
docker stop $(docker ps -q -f name=ethereum)
docker rm $(docker ps -aq -f name=ethereum)
rm -Rf $DATA_ROOT/.ethash
rm -Rf $DATA_ROOT/.bootnode
#rm genesis.json
