package com.example.bankService.services;

import com.example.bankService.dto.BillingRequestDto;
import com.example.bankService.dto.BillingResponse;
import com.example.bankService.dto.CustomerRequestDto;
import com.example.bankService.dto.CustomerResponse;
import com.example.bankService.models.Customer;
import com.example.bankService.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private  CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
      //  customerRepository.deleteAll();

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    @DisplayName("Create Customer Test")
    void testThatCustomerCanBeCreated(){
        CustomerRequestDto customerRequestDto = new CustomerRequestDto();
        customerRequestDto.setFirstname("Florence");
        customerRequestDto.setLastName("Aniyikaye");
        customerRequestDto.setEmail("florence.aniyikaye@yahoo");
        CustomerResponse response = customerService.createCustomer(customerRequestDto);
        assertNotNull(response);
        assertEquals("Florence",response.getCustomer().getFirstname());
        assertEquals("Aniyikaye",response.getCustomer().getLastName());
        assertEquals("florence.aniyikaye@yahoo",response.getCustomer().getEmail());
    }

    @Test
    @DisplayName("Retrieve A Customer")
    void testThatACustomerCanBeRetrieved(){
        CustomerResponse response = customerService.findCustomerById(3L);
        assertEquals("Florence",response.getCustomer().getFirstname());
    }

    @Test
    @DisplayName("Create Bill For Customer")
    void testThatBillCanBeAssignedToACustomer(){
        BillingRequestDto requestDto = new BillingRequestDto();
        requestDto.setCustomerId(3L);
        requestDto.setTariff("45000");
        BillingResponse response = customerService.createBilling(requestDto);
        assertNotNull(response);
    }

}