prerequisites: Go, Web3j, Solc

ENV SETUP
sudo apt-get update
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


FROM ETHEREUM
set timezone!
docker-compose up -d 
./bootnode.sh
./genesis.sh
./runminer.sh
./runattach.sh


FROM CONTRACTS
./redeploy-contract.sh

ANYWHERE
 docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres

https://github.com/vertigobr/ethereum

note to self - wipeall wipes keystore too`