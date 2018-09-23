package com.example.ethereum.repositories;

import com.example.ethereum.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, Long> {
    Account findOneByUsername (String username);

}
