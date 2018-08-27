package com.example.ethereum.models;


import javax.persistence.*;

@Table
@Entity
public class ContractAddress {

    public ContractAddress(String coachee, String contractAddress){
        this.coachee=coachee;
        this.contractAddress=contractAddress;
    }

    public ContractAddress(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    String coachee;

    @Column()
    String contractAddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoachee() {
        return coachee;
    }

    public void setCoachee(String coachee) {
        this.coachee = coachee;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }
}
