package com.udea.edu.co.directorio.repositories;


import com.udea.edu.co.directorio.entities.HomeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeInfoRepository extends CrudRepository<HomeInfo,Integer> {
    HomeInfo findHomeInfoById(int id);
}
