<h2>Setup environment</h2>
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

<h2>Start private network</h2>
```./runminer.sh
./runattach.sh
```

Based on https://github.com/vertigobr/ethereum


<h2>Deploy smart contract</h2>
./redeploy-contract.sh

<h2>Start database</h2>
docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres


