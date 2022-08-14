package com.example.bankService.dto;


import lombok.Data;

@Data
public class BillingRequestDto {
    private Long customerId;
    private  String tariff;
}
