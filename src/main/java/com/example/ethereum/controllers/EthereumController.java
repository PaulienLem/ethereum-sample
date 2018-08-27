package com.example.ethereum.controllers;

import com.example.ethereum.models.ContractAddress;
import com.example.ethereum.repositories.ContractAddressRepository;
import com.example.ethereum.wrappers.CoachingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

@RestController
@RequestMapping
public class EthereumController {

    @Autowired
    private ContractAddressRepository contractAddressRepository;

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
            CoachingPlan coachingPlan = CoachingPlan.deploy(web3j, WalletUtils.loadCredentials("sweetmustard", new File("/Users/paulien/gethDataDir/keystore/UTC--2018-08-22T13-06-45.541742377Z--37cca84899e8822b0acd99e015bdeee3e2150487")), GAS_PRICE, BigInteger.valueOf(2934465)).send();
            contractAddressRepository.save(new ContractAddress(coachingPlan.coachee().sendAsync().get(), coachingPlan.getContractAddress()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public void createAccount() {
        try {
            String file = WalletUtils.generateNewWalletFile("sweetmustard", new File("/Users/paulien/gethDataDir/keystore"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CoachingPlan getSmartContract() {
        try {
            Web3j web3j = Web3j.build(new HttpService());
            ContractAddress address = contractAddressRepository.findOneByCoachee("Paulien");
            return CoachingPlan.load(address.getContractAddress(), web3j, WalletUtils.loadCredentials("sweetmustard", new File("/Users/paulien/gethDataDir/keystore/UTC--2018-08-22T13-06-45.541742377Z--37cca84899e8822b0acd99e015bdeee3e2150487")),GAS_PRICE, Contract.GAS_LIMIT);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }
}
