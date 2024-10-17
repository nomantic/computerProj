package com.example.demojar.service;

import com.example.demojar.entity.ComputerEntity;
import com.example.demojar.repository.CRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CService {
    @Autowired
    private CRepository cRepository;

    public List<ComputerEntity> getComputerEntity() {
        return cRepository.findAll();

    }

    public ComputerEntity saveComputerEntity(ComputerEntity computerEntity) {
        return cRepository.save(computerEntity);
    }

    public Double getAveragePrice(){
        List<ComputerEntity> computers = cRepository.findAll();
        double sum = 0;
        for(ComputerEntity computer : computers){
            sum += computer.getPrice();
        }
        return sum / computers.size();
    }

    public List<ComputerEntity> getComputerEntitiesSortDesc() {
        return cRepository.findAllByOrderByPriceAsc();
    }

    public List<ComputerEntity> getSpecificPrice(Long i){
        return cRepository.findAllByPriceIsBefore(i);
    }
}
