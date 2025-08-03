package com.keyin.server.service;

import com.keyin.server.entity.Customer;
import com.keyin.server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers() {return customerRepository.findAll();}
    
    public Customer getCustomerByID(Long ID) {return customerRepository.findById(ID).orElse(null);}
    
    public Customer saveCustomer(Customer customer) {return customerRepository.save(customer);}
    
    public Customer updateCustomer(Long ID, Customer customer) {
        customer.setID(ID);
        return customerRepository.save(customer);
    }
    
    public void deleteCustomer(Long ID) {
        customerRepository.deleteById(ID);
    }
    
    public List<Customer> searchByName(String name) {
        return customerRepository.findByFirstNameOrLastName(name, name);
    }
} 