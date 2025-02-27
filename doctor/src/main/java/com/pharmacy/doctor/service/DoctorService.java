package com.pharmacy.doctor.service;

import com.pharmacy.doctor.dto.OrderDTO;
import com.pharmacy.doctor.entity.Order;
import com.pharmacy.doctor.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private OrderRepository orderRepository;

    // Place a new order
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setDoctorName(orderDTO.getDoctorName());
        order.setDrugName(orderDTO.getDrugName());
        order.setQuantity(orderDTO.getQuantity());
        order.setStatus("Pending"); // Default status
        orderRepository.save(order);
        return orderDTO;
    }

    // Get all orders placed by doctors
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderDTO(order.getDoctorName(), order.getDrugName(), order.getQuantity(), order.getStatus()))
                .collect(Collectors.toList());
    }
}
