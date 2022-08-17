package com.example.bankService.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class InvoiceResponse {
    private String id;
    private String firstName;
    private  String lastName;
    private  String accountNumber;
    private String  amountToBePaid;

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber='" +accountNumber + '\'' +
                ", amountToBePaid='" +amountToBePaid + '\'' +
                '}';
    }
}
