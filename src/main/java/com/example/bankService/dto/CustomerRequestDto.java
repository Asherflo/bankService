package com.example.bankService.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private String firstname;
    private String lastName;
    private String email;
}
