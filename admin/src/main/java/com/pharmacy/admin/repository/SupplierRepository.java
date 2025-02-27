package com.pharmacy.admin.repository;

import com.pharmacy.admin.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
