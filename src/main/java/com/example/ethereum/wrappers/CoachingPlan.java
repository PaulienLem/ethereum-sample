package com.example.ethereum.wrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class CoachingPlan extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040805180820190915260048082527f4d696b65000000000000000000000000000000000000000000000000000000006020909201918252610055916000916100a0565b506040805180820190915260078082527f5061756c69656e00000000000000000000000000000000000000000000000000602090920191825261009a916001916100a0565b5061013b565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100e157805160ff191683800117855561010e565b8280016001018555821561010e579182015b8281111561010e5782518255916020019190600101906100f3565b5061011a92915061011e565b5090565b61013891905b8082111561011a5760008155600101610124565b90565b6107f38061014a6000396000f30060806040526004361061006c5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663120e42a3811461007157806342e35f631461009e57806361449ca2146100c05780639c0382ef146100ed578063e4ac1c6514610102575b600080fd5b34801561007d57600080fd5b50610086610117565b604051610095939291906106d8565b60405180910390f35b3480156100aa57600080fd5b506100be6100b93660046105d0565b610329565b005b3480156100cc57600080fd5b506100e06100db36600461060d565b610372565b60405161009591906106c7565b3480156100f957600080fd5b506100e0610419565b34801561010e57600080fd5b506100e0610473565b6060806060600060016002828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156101b75780601f1061018c576101008083540402835291602001916101b7565b820191906000526020600020905b81548152906001019060200180831161019a57829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959850879450925084019050828280156102455780601f1061021a57610100808354040283529160200191610245565b820191906000526020600020905b81548152906001019060200180831161022857829003601f168201915b5050505050915080805480602002602001604051908101604052809291908181526020016000905b828210156103185760008481526020908190208301805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152928301828280156103045780601f106102d957610100808354040283529160200191610304565b820191906000526020600020905b8154815290600101906020018083116102e757829003601f168201915b50505050508152602001906001019061026d565b505050509050925092509250909192565b6002805460018101808355600092909252825161036d917f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace019060208501906104ce565b505050565b600280548290811061038057fe5b600091825260209182902001805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152935090918301828280156104115780601f106103e657610100808354040283529160200191610411565b820191906000526020600020905b8154815290600101906020018083116103f457829003601f168201915b505050505081565b60018054604080516020600284861615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156104115780601f106103e657610100808354040283529160200191610411565b6000805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156104115780601f106103e657610100808354040283529160200191610411565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061050f57805160ff191683800117855561053c565b8280016001018555821561053c579182015b8281111561053c578251825591602001919060010190610521565b5061054892915061054c565b5090565b61056691905b808211156105485760008155600101610552565b90565b6000601f8201831361057a57600080fd5b813561058d61058882610741565b61071a565b915080825260208301602083018583830111156105a957600080fd5b6105b4838284610773565b50505092915050565b60006105c98235610566565b9392505050565b6000602082840312156105e257600080fd5b813567ffffffffffffffff8111156105f957600080fd5b61060584828501610569565b949350505050565b60006020828403121561061f57600080fd5b600061060584846105bd565b60006106368261076f565b8084526020840193508360208202850161064f85610769565b60005b8481101561068657838303885261066a838351610692565b925061067582610769565b602098909801979150600101610652565b50909695505050505050565b600061069d8261076f565b8084526106b181602086016020860161077f565b6106ba816107af565b9093016020019392505050565b602080825281016105c98184610692565b606080825281016106e98186610692565b905081810360208301526106fd8185610692565b90508181036040830152610711818461062b565b95945050505050565b60405181810167ffffffffffffffff8111828210171561073957600080fd5b604052919050565b600067ffffffffffffffff82111561075857600080fd5b506020601f91909101601f19160190565b60200190565b5190565b82818337506000910152565b60005b8381101561079a578181015183820152602001610782565b838111156107a9576000848401525b50505050565b601f01601f1916905600a265627a7a72305820d8ec32ee76c6856c833abb29a13f2d77618274e42d056bb739c2bd59cbd0cc266c6578706572696d656e74616cf50037";

    public static final String FUNC_GETCOACHINGPLAN = "getCoachingPlan";

    public static final String FUNC_ADDGOAL = "addGoal";

    public static final String FUNC_GOALS = "goals";

    public static final String FUNC_COACHEE = "coachee";

    public static final String FUNC_COACH = "coach";

    protected CoachingPlan(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CoachingPlan(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple3<String, String, List<String>>> getCoachingPlan() {
        final Function function = new Function(FUNC_GETCOACHINGPLAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicArray<Utf8String>>() {}));
        return new RemoteCall<Tuple3<String, String, List<String>>>(
                new Callable<Tuple3<String, String, List<String>>>() {
                    @Override
                    public Tuple3<String, String, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, List<String>>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                convertToNative((List<Utf8String>) results.get(2).getValue()));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addGoal(String _goal) {
        final Function function = new Function(
                FUNC_ADDGOAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_goal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> goals(BigInteger param0) {
        final Function function = new Function(FUNC_GOALS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> coachee() {
        final Function function = new Function(FUNC_COACHEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> coach() {
        final Function function = new Function(FUNC_COACH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<CoachingPlan> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CoachingPlan.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CoachingPlan> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CoachingPlan.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static CoachingPlan load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CoachingPlan(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static CoachingPlan load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CoachingPlan(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
