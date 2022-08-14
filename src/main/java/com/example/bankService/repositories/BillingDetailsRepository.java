package com.example.bankService.repositories;

import com.example.bankService.models.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingDetailsRepository extends JpaRepository<BillingDetails,Long> {
}
