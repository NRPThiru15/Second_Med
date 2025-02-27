package com.pharmacy.doctor.repository;

import com.pharmacy.doctor.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
