<h1>Ethereum Sample</h1>


<h2>Prerequisites</h2>
<li> Java (tested with java8) </li>
<li> Node (tested with 9.11.1) </li>
<li> git (apt-get install git-core) </li>
<li>  Python 2.X (Sudo apt install python-minimal) </li>
<li>  GCC (Sudo apt install gcc) </li>
<li> build-essential (sudo apt-get install build-essential) </li>
<li> Maven (Sudo apt-get install maven) </li>

<h2>Setup Environment</h2>
<li> Install Docker </li>
<li> Install Geth </li>

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

- Install SolC
```aidl
Npm install -g solc
```

- Install Web3J
```aidl
Npm install -g web3
```

<h2>Run application</h2>

<h3>Running Ethereum</h3>

<h4> Startup </h4>

Run `````./runminer.sh````` to start the miner node. Check the logs by running ```docker ps``` to get the container ID and then ```docker logs CONTAINER_ID -f```. 
When the DAG generation process has finished and the logs say 'commit new mining work', run `````./runattach.sh````` to open RPC connection with the miner node.
Generating DAG usually takes a while. 

<h4> Teardown </h4>

```aidl
./wipeall.sh
```

<h3>Spin up database</h3>
docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres


<h3>Start the Springboot app</h3>

<h3>Deploy smart contract</h3>
./redeploy-contract.sh

<h3>Test API</h3>
<li> POST to localhost:9000/ to create a smart contract (might take a few minutes) </li>
<li> GET to localhost:9000/ to get the coachee of the smart contract created </li>


Based on https://github.com/vertigobr/ethereum
