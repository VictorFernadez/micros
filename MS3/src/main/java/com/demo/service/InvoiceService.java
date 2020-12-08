package com.demo.service;

import com.demo.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    public List<Invoice> findInvoiceAll();
    public Invoice createInvoice(Invoice invoice);
    public Invoice updatedInvoice(Invoice invoice);
    public Invoice deletedInvoice(Invoice invoice);
    public Invoice getInvoice(Long id);
}
