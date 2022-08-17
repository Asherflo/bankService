package com.example.bankService.services;

import com.example.bankService.dto.*;
import com.example.bankService.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequestDto customerRequestDto);
    CustomerResponse findCustomerById(long customerId);
    BillingResponse createBilling(BillingRequestDto requestDto);

    List<Customer> findAllCustomer();

    InvoiceResponse toString(InvoiceRequestDto invoiceRequestDto);

}
