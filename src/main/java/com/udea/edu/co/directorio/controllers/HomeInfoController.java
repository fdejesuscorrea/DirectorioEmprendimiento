package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.HomeInfo;
import com.udea.edu.co.directorio.repositories.HomeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeInfoController {
    @Autowired
    private HomeInfoRepository homeInfoRepository;
    @GetMapping
    public ResponseEntity<List<HomeInfo>> getHomeInfoById() {
        List<HomeInfo> homeInfo=new ArrayList<>();
        homeInfo.add(homeInfoRepository.findHomeInfoById(1));
        return new ResponseEntity<>(homeInfo, HttpStatus.OK);
    }
}
