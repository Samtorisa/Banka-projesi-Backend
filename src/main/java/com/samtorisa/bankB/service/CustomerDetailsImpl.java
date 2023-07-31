/*package com.samtorisa.bankB.service;

import com.samtorisa.bankB.entity.Customer;
import com.samtorisa.bankB.repository.CustomerRepository;
import com.samtorisa.bankB.security.JwtCustomerDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsImpl implements UserDetailsService {

     private CustomerRepository customerRepo;

    public CustomerDetailsImpl(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Customer customer=customerRepo.findByMail(mail);
        return JwtCustomerDetails.create(customer);
    }

    public UserDetails loadCustomerById(Long id) {
        Customer customer=customerRepo.findById(id).get();
        return JwtCustomerDetails.create(customer);

    }

}
*/