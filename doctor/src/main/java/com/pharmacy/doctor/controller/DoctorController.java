package com.pharmacy.doctor.controller;

import com.pharmacy.doctor.dto.OrderDTO;
import com.pharmacy.doctor.feign.AdminServiceClient;
import com.pharmacy.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AdminServiceClient adminServiceClient;

    // Place a new order
    @PostMapping("/order")
    public OrderDTO placeOrder(@RequestBody OrderDTO orderDTO) {
        return doctorService.placeOrder(orderDTO);
    }

    // Get all orders placed by doctors
    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders() {
        return doctorService.getAllOrders();
    }

    // Fetch all available drugs from Admin Service
    @GetMapping("/drugs")
    public String getAllDrugs() {
        return adminServiceClient.getAllDrugs();
    }
}
