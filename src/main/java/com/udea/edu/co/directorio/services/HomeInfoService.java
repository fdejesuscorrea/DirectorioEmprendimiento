package com.udea.edu.co.directorio.services;

import com.udea.edu.co.directorio.entities.HomeInfo;
import com.udea.edu.co.directorio.repositories.HomeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeInfoService {
    private final HomeInfoRepository homeInfoRepository;

    @Autowired
    public HomeInfoService(HomeInfoRepository homeInfoRepository) {
        this.homeInfoRepository = homeInfoRepository;
    }
    public HomeInfo getHomeInfo(){
        return homeInfoRepository.findHomeInfoById(1);
    }
}
