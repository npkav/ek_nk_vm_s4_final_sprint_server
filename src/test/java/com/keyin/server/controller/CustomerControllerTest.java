package com.keyin.server.controller;

import com.keyin.server.entity.Customer;
import com.keyin.server.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private CustomerRepository repo;

    @Test
    void getAll() throws Exception {
        when(repo.findAll()).thenReturn(Arrays.asList(
            new Customer("MF", "Doom", "mfdoom@rhymesayers.com")));
        mvc.perform(get("/api/customer"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].firstName").value("MF"));
    }

    @Test
    void getByID() throws Exception {
        Customer customer = new Customer("MF", "Doom", "mfdoom@rhymesayers.com");
        customer.setID(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(customer));
        mvc.perform(get("/api/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("MF"));
    }
} 