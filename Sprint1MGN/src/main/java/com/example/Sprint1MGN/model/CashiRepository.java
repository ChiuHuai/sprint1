package com.example.Sprint1MGN.model;

import com.example.Sprint1MGN.model.entity.Cashi;
import com.example.Sprint1MGN.model.entity.CashiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashiRepository extends JpaRepository<Cashi, CashiId> {
}
