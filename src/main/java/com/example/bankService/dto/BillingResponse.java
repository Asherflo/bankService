package com.example.bankService.dto;

import com.example.bankService.models.BillingDetails;
import lombok.Data;

@Data
public class BillingResponse {
    private String message;
    private BillingDetails billingDetails;
}
