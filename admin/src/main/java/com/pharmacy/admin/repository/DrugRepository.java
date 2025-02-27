package com.pharmacy.admin.repository;

import com.pharmacy.admin.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {
}
