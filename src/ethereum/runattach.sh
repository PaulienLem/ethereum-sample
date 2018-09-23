#!/bin/sh
docker exec -ti "ethereum-miner1" sh -c "geth attach && "
docker exec -ti "ethereum-miner1" geth --exec 'miner.setEtherbase(eth.accounts[0])' attach

