package com.samtorisa.bankB.repository;

import com.samtorisa.bankB.entity.Account;
import com.samtorisa.bankB.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {


    List<Account> findByCustomerId(Long customerId);
}
