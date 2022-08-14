package com.example.bankService.dto;

import com.example.bankService.models.Customer;
import lombok.Data;

@Data
public class CustomerResponse {
    private String message;
    private Customer customer;
}
