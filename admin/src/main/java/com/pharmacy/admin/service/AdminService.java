package com.pharmacy.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.admin.dto.DrugDTO;
import com.pharmacy.admin.entity.Drug;
import com.pharmacy.admin.feign.OrderServiceClient;
import com.pharmacy.admin.repository.DrugRepository;

@Service
public class AdminService {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private OrderServiceClient orderServiceClient;

    // Add a new drug
    public DrugDTO addDrug(DrugDTO drugDTO) {
        Drug drug = new Drug();
        drug.setName(drugDTO.getName());
        drug.setPrice(drugDTO.getPrice());
        drug.setQuantity(drugDTO.getQuantity());
        drugRepository.save(drug);
        return drugDTO;
    }

    // Get all drugs
    public List<DrugDTO> getAllDrugs() {
        return drugRepository.findAll().stream()
                .map(drug -> new DrugDTO(drug.getName(), drug.getPrice(), drug.getQuantity()))
                .collect(Collectors.toList());
    }

    // Fetch order details using Feign Client
    public String getOrderDetails(Long orderId) {
        return orderServiceClient.getOrderDetails(orderId);
    }
}
