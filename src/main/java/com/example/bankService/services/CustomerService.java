package com.example.bankService.services;

import com.example.bankService.dto.BillingRequestDto;
import com.example.bankService.dto.BillingResponse;
import com.example.bankService.dto.CustomerRequestDto;
import com.example.bankService.dto.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequestDto customerRequestDto);
    CustomerResponse findCustomerById(long customerId);
    BillingResponse createBilling(BillingRequestDto requestDto);
}
