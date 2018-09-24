package com.example.ethereum;

import com.example.ethereum.utils.Web3jUtils;
import com.example.ethereum.wrappers.CoachingPlan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.io.File;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;


@SpringBootApplication
public class EthereumApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(EthereumApplication.class, args);

		Web3j web3j = Web3j.build(new HttpService());

		EthMining mining = web3j.ethMining().sendAsync().get();
		EthCoinbase coinbase = web3j.ethCoinbase().sendAsync().get();
		EthAccounts accounts = web3j.ethAccounts().sendAsync().get();

		System.out.println("Client is mining: " + mining.getResult());
		System.out.println("Coinbase address: " + coinbase.getAddress());
		System.out.println("Coinbase coins: " + Web3jUtils.getBalanceEther(web3j,  coinbase.getAddress()));
		System.out.println(accounts.getAccounts().get(0) + " has " + Web3jUtils.getBalanceEther(web3j, accounts.getAccounts().get(0)));
		System.out.println(accounts.getAccounts());
	}
}
