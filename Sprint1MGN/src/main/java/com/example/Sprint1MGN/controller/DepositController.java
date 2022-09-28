package com.example.Sprint1MGN.controller;

import com.example.Sprint1MGN.controller.dto.request.ClearingAccount;
import com.example.Sprint1MGN.controller.dto.request.DepositRequest;
import com.example.Sprint1MGN.controller.dto.response.DepositResponse;
import com.example.Sprint1MGN.model.CashiRepository;
import com.example.Sprint1MGN.model.MgniRepository;
import com.example.Sprint1MGN.model.entity.Cashi;
import com.example.Sprint1MGN.model.entity.Mgni;
import com.example.Sprint1MGN.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/deposit")

public class DepositController {
    @Autowired
    private DepositService depositService;

    @PostMapping()
    public DepositResponse deposit(@Valid @RequestBody DepositRequest request){
        DepositResponse response;
//        try{
             response = depositService.deposit(request);
//        }catch(Exception e){
//            return new DepositResponse().builder().message(e.getMessage()).build();
//        }
        return response;
    }

    
}
