package com.samtorisa.bankB.controller;

import com.samtorisa.bankB.entity.Customer;
import com.samtorisa.bankB.request.CustomerRequest;
import com.samtorisa.bankB.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getAllUser(){
        return customerService.getAllUser();
    }

    @PostMapping
    public Customer createOneCustomer(@RequestBody CustomerRequest newCustomer){
        return customerService.createOneCustomer(newCustomer);
    }
    @GetMapping("/{customerId}")
    public Customer getOneUser(@PathVariable Long customerId){
        return customerService.getOneUser(customerId);

    }
    @DeleteMapping("/{customerId}")
    public void deleteOneUser(@PathVariable Long customerId){
        customerService.deleteOneUser(customerId);

    }

}
