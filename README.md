#Ethereum Sample

##Setup Environment
Install Docker
Install Go and Geth

```sudo apt-get update
sudo apt-get upgrade
sudo apt-get install -y build-essential
sudo apt-get install git
cd ~
git clone https://github.com/ethereum/go-ethereum.git

cd ~
wget https://dl.google.com/go/go1.9.3.linux-amd64.tar.gz
sudo tar -C /usr/local -xzf go1.9.3.linux-amd64.tar.gz
add to ~/.profile : export PATH="$PATH:/usr/local/go/bin"

cd ~
cd go-ethereum
make geth
```

Install SolC

Install Web3J

##Run application

###Running Ethereum

####Startup 

Run ./runminer.sh to start the miner node. Check the logs by running 'docker ps' to get the container ID and then 'docker logs CONTAINER_ID -f'. 
When the DAG generation process has finished and the logs say 'commit new mining work', run ./runattach.sh to open RPC connection with the miner node.
Generating DAG usually takes a while. 

#### Teardown
```
./wipeall.sh
```

###Spin up database
docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres


###Start the Springboot app

###Deploy smart contract
./redeploy-contract.sh

###Test API
- POST to localhost:9000/ to create a smart contract (might take a few minutes)
- GET to localhost:9000/ to get the coachee of the smart contract created


Based on https://github.com/vertigobr/ethereum
