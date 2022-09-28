package com.example.Sprint1MGN.controller;

import com.example.Sprint1MGN.model.MgniRepository;
import com.example.Sprint1MGN.model.entity.Mgni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/mgni")
public class MgniController {

    @Autowired
    private MgniRepository mgniReository;

    @GetMapping(path = "/findAll", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Mgni> findAllMgni() {
        List<Mgni> mgniList = mgniReository.findAll();
        return mgniList;
    }
}
