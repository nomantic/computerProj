package com.example.demojar.controllar;

import com.example.demojar.entity.ComputerEntity;
import com.example.demojar.service.CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CControllar {

    @Autowired
    private CService service;

    @GetMapping
    public String helloWorld() {
        return "Hello World!";
    }
    @GetMapping("/get")
    public List<ComputerEntity> getComputers(){
        return service.getComputerEntity();
    }

    @PostMapping("/save")
    public void saveComputer(@RequestBody ComputerEntity computer){
        service.saveComputerEntity(computer);
    }

    @GetMapping("/getAverage")
    public Double getAverage(){
        return service.getAveragePrice();
    }

    @GetMapping("/lowPriceSort")
    public List<ComputerEntity> getLowPriceSort(){
        return service.getComputerEntitiesSortDesc();
    }

    @GetMapping("/lowerThanPrice")
    public List<ComputerEntity> getLowerThanPrice(){
        return service.getSpecificPrice(1300L);
    }
}
