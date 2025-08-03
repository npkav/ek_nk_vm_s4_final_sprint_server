package com.keyin.server.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void constructor() {
        Customer customer = new Customer("MF", "Doom", "mfdoom@rhymesayers.com");
        
        assertEquals("MF", customer.getFirstName());
        assertEquals("Doom", customer.getLastName());
        assertEquals("mfdoom@rhymesayers.com", customer.getEmail());
        assertNull(customer.getID());
    }

    @Test
    void setters() {
        Customer customer = new Customer();
        customer.setFirstName("MF");
        customer.setLastName("Doom");
        
        assertEquals("MF", customer.getFirstName());
        assertEquals("Doom", customer.getLastName());
    }
} 