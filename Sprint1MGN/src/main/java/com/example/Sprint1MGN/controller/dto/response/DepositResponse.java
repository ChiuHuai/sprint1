package com.example.Sprint1MGN.controller.dto.response;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class DepositResponse {
    //private List resultList; //Result and SumResult
    //private String responseCode;
    private String message;
}
