package com.example.ethereum.DTO;

public class ContractCreationDto {
    private String creator;
    private String coach;
    private String coachee;

    public ContractCreationDto(String creator, String coach, String coachee){
        this.creator=creator;
        this.coach=coach;
        this.coachee=coachee;
    }

    public ContractCreationDto(){}

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCoachee() {
        return coachee;
    }

    public void setCoachee(String coachee) {
        this.coachee = coachee;
    }
}
