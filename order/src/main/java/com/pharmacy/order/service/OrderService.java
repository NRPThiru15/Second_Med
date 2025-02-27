package com.pharmacy.order.service;

import com.pharmacy.order.dto.OrderDTO;
import com.pharmacy.order.entity.Order;
import com.pharmacy.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Save a new order
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setDoctorName(orderDTO.getDoctorName());
        order.setDrugName(orderDTO.getDrugName());
        order.setQuantity(orderDTO.getQuantity());
        order.setStatus(orderDTO.getStatus());
        orderRepository.save(order);
        return orderDTO;
    }

    // Get all orders
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderDTO(order.getDoctorName(), order.getDrugName(), order.getQuantity(), order.getStatus()))
                .collect(Collectors.toList());
    }
}
