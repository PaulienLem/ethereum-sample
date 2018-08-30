package com.example.ethereum.controllers;

import com.example.ethereum.models.Account;
import com.example.ethereum.models.ContractAddress;
import com.example.ethereum.repositories.AccountRepository;
import com.example.ethereum.repositories.ContractAddressRepository;
import com.example.ethereum.utils.Web3jConstants;
import com.example.ethereum.utils.Web3jUtils;
import com.example.ethereum.wrappers.CoachingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

@RestController
@RequestMapping
public class EthereumController {

    @Autowired
    private ContractAddressRepository contractAddressRepository;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCoachee() {
        String returnString = "";
        try {
            returnString = getSmartContract().coachee().sendAsync().get();
        } catch(Exception e){
            e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createSmartContract() {
        try {
            Web3j web3j = Web3j.build(new HttpService());
            CoachingPlan coachingPlan = CoachingPlan.deploy(web3j, WalletUtils.loadCredentials("sweetmustard", new File("/Users/paulien/Documents/Research/ethereum-sample/src/ethereum/.ether-miner1/keystore/UTC--2018-08-28T11-53-50.666000000Z--2549f66398d9b13a322ab2569ae4b5c85c2f8635.json")), GAS_PRICE, BigInteger.valueOf(2934465)).send();
            contractAddressRepository.save(new ContractAddress(coachingPlan.coachee().sendAsync().get(), coachingPlan.getContractAddress()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public void createAccount(@RequestBody Account account) {
        try {
            String file = WalletUtils.generateNewWalletFile(account.getPassword(), new File("/Users/paulien/Documents/Research/ethereum/.ether-miner1/keystore"), true);
            account.setFile(file);
            accountRepository.save(account);
            System.out.println(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CoachingPlan getSmartContract() {
        try {
            Web3j web3j = Web3j.build(new HttpService());
            ContractAddress address = contractAddressRepository.findOneByCoachee("Paulien");
            System.out.println(address.getContractAddress());
            return CoachingPlan.load(address.getContractAddress(), web3j, WalletUtils.loadCredentials("sweetmustard", new File("/Users/paulien/Documents/Research/ethereum-sample/src/ethereum/.ether-miner1/keystore/UTC--2018-08-28T11-53-50.666000000Z--2549f66398d9b13a322ab2569ae4b5c85c2f8635.json")),GAS_PRICE, Contract.GAS_LIMIT);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
}
