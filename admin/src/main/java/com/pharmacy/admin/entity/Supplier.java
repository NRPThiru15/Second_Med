package com.pharmacy.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contact;
}
