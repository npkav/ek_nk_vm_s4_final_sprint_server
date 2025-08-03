package com.keyin.server.service;

import com.keyin.server.entity.Customer;
import com.keyin.server.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository repo;

    @InjectMocks
    private CustomerService service;

    @Test
    void getAll() {
        Customer customer = new Customer("MF", "Doom", "mfdoom@rhymesayers.com");
        when(repo.findAll()).thenReturn(Arrays.asList(customer));

        List<Customer> result = service.getAllCustomers();
        
        assertEquals(1, result.size());
    }

    @Test
    void getByID() {
        Customer customer = new Customer("MF", "Doom", "mfdoom@rhymesayers.com");
        customer.setID(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(customer));
        
        Customer result = service.getCustomerByID(1L);
        
        assertEquals(1, result.getID());
        assertNotNull(result);
        assertEquals("MF", result.getFirstName());
        assertEquals("Doom", result.getLastName());
        assertEquals("mfdoom@rhymesayers.com", result.getEmail());
    }
} 