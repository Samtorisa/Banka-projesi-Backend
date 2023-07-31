package com.samtorisa.bankB.service;

import com.samtorisa.bankB.entity.Customer;
import com.samtorisa.bankB.repository.CustomerRepository;
import com.samtorisa.bankB.request.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllUser() {
    return customerRepository.findAll();
    }

    public Customer createOneCustomer(CustomerRequest newCustomer) {
        Customer customerSave =new Customer();
        customerSave.setMail(newCustomer.getMail());
        customerSave.setPassword(newCustomer.getPassword());

    return customerRepository.save(customerSave);
    }

    public Customer getOneUser(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);

    }

    public void deleteOneUser(Long customerId) {
           customerRepository.deleteById(customerId);
    }

    public Customer getOneCustomerByMail(String mail) {
        return customerRepository.findByMail(mail);



    }
}
