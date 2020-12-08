package com.demo.repository;

import com.demo.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemseRepository extends JpaRepository<InvoiceItem,Long> {
}
