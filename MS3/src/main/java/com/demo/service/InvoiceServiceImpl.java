package com.demo.service;

import com.demo.entity.Invoice;
import com.demo.repository.InvoiceItemseRepository;
import com.demo.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceItemseRepository invoiceItemseRepository;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
        if(invoiceDB == null){
            return invoiceDB;
        }
        invoice.setState("CREATED");

        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updatedInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if(invoiceDB == null){
            return null;
        }
        invoiceDB.setCustomerId(invoice.getCustomerId());
        invoiceDB.setDescription(invoice.getDescription());
        invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
        invoiceDB.getItems().clear();
        invoiceDB.setItems(invoice.getItems());
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice deletedInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if(invoiceDB == null){
            return null;
        }
        invoice.setState("DELETED");
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }
}
