package com.example.bankService.services;

import com.example.bankService.dto.*;
import com.example.bankService.models.BillingDetails;
import com.example.bankService.models.Customer;
import com.example.bankService.repositories.BillingDetailsRepository;
import com.example.bankService.repositories.CustomerRepository;
import com.example.bankService.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final BillingDetailsRepository billingDetailsRepository;
     private final InvoiceRepository invoiceRepository;
    @Override
    public CustomerResponse createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setFirstname(customerRequestDto.getFirstname());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setEmail(customerRequestDto.getEmail());
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponse response = new CustomerResponse();
        response.setMessage("Success");
        response.setCustomer(savedCustomer);
        return  response;
    }

    @Override
    public CustomerResponse findCustomerById(long customerId) {
        Optional<Customer> customerRepo = customerRepository.findById(customerId);
        Customer customer = customerRepo.get();
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setMessage("Seen");
        customerResponse.setCustomer(customer);
        return customerResponse;
    }

    @Override
    public BillingResponse createBilling(BillingRequestDto requestDto) {
        Optional<Customer> customerRepo = customerRepository.findById(requestDto.getCustomerId());
        Customer customer = customerRepo.get();
        BillingDetails billingDetails = new BillingDetails();
        billingDetails.setTariff(requestDto.getTariff());
        String accountNumber = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        accountNumber = accountNumber.substring(1,10);
        billingDetails.setAccountNumber(accountNumber+"-01");
        billingDetails.setCustomerId(customer);
        BillingDetails saveBillingDetails = billingDetailsRepository.save(billingDetails);

        BillingResponse response = new BillingResponse();
        response.setMessage("Success");
        response.setBillingDetails(saveBillingDetails);
        return response;

    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public InvoiceResponse toString(InvoiceRequestDto invoiceRequestDto) {
        return null;
    }


    @Override
    public String toString() {
        return invoiceRepository.toString();
    }
}
