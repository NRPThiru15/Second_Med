package com.pharmacy.order.Controller;

import com.pharmacy.order.dto.OrderDTO;
import com.pharmacy.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Save a new order
    @PostMapping
    public OrderDTO saveOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }

    // Get all orders
    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
}
