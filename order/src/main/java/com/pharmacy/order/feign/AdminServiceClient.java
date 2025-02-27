package com.pharmacy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "admin-service", url = "http://localhost:8081")  // Replace with actual service name
public interface AdminServiceClient {

    @GetMapping("/admin/drugs")
    String getAllDrugs();
}
