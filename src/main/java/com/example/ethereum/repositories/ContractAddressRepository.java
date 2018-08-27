package com.example.ethereum.repositories;

import com.example.ethereum.models.ContractAddress;
import com.example.ethereum.wrappers.CoachingPlan;
import org.springframework.data.repository.CrudRepository;


public interface ContractAddressRepository extends CrudRepository<ContractAddress, Long>{
    ContractAddress findOneByCoachee (String coachee);
}
