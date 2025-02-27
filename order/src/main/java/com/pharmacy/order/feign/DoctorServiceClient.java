package com.pharmacy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service", url = "http://localhost:8082") // Replace with actual service name
public interface DoctorServiceClient {

    @GetMapping("/doctor/orders")
    String getDoctorOrders();
}
