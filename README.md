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

cd ~
mkdir gethDataDir
geth account new --datadir ~/gethDataDir

add genesis.json
{
	"config": {
		"chainId": 15,
		"homesteadBlock": 0,
		"eip155Block": 0,
		"eip158Block": 0
	},
	"difficulty": "1",
	"gasLimit": "2100000",
	"alloc":{
	        "yourNewlyCreatedAccountAddressMustGoHere": {
			"balance": "300000"
		},
		"yourNewlyCreatedAccountAddressMustGoHere": {
			"balance": "400000"
		},
		"yourNewlyCreatedAccountAddressMustGoHere": {
			"balance": "500000"
		}
	}
}

FROM SRC
geth removedb if needed
./run-ethereum.sh

FROM CONTRACTS
./redeploy-contract.sh

ANYWHERE
 docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
