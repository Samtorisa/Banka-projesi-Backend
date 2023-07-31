package com.samtorisa.bankB.repository;

import com.samtorisa.bankB.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByMail(String mail);
}
