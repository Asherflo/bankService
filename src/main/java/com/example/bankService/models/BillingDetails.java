package com.example.bankService.models;
import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BillingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    private String tariff;

    @ManyToOne
//    @JoinColumn(name="customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerId;

}
