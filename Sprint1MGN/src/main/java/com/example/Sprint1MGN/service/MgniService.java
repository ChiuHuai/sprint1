package com.example.Sprint1MGN.service;

import com.example.Sprint1MGN.model.MgniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MgniService {
    @Autowired
    private MgniRepository mgniReository;
}
