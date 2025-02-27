package com.pharmacy.doctor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8083") // Replace with actual service name
public interface OrderServiceClient {

    @GetMapping("/order/{id}")
    String getOrderDetails(@PathVariable("id") Long orderId);
}
