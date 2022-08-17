package com.example.bankService.services;

import com.example.bankService.dto.InvoiceRequestDto;
import com.example.bankService.dto.InvoiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {

    InvoiceResponse toString(InvoiceRequestDto invoiceRequestDto);

    InvoiceResponse createInvoice(InvoiceRequestDto invoiceRequestDto);
}
