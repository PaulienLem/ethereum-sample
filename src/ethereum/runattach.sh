#!/bin/sh
NODE=$1
NODE=${NODE:-"ethereum-miner1"}
docker exec -ti "$NODE" sh -c "geth attach && "
docker exec -ti "$NODE" geth --exec 'miner.setEtherbase(eth.accounts[0])' attach

#