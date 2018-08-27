#!/bin/bash

rm compiled/* && rm ../main/java/com/example/ethereum/wrappers/*
solc coachingPlan.sol --bin --abi --optimize -o compiled
web3j solidity generate ./compiled/CoachingPlan.bin ./compiled/CoachingPlan.abi -o ../main/java/ -p com.example.ethereum.wrappers


