package com.pharmacy.admin.controller;

import com.pharmacy.admin.dto.DrugDTO;
import com.pharmacy.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Add a new drug
    @PostMapping("/drug")
    public DrugDTO addDrug(@RequestBody DrugDTO drugDTO) {
        return adminService.addDrug(drugDTO);
    }

    // Get all drugs
    @GetMapping("/drugs")
    public List<DrugDTO> getAllDrugs() {
        return adminService.getAllDrugs();
    }
}
