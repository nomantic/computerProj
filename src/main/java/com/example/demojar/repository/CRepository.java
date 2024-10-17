package com.example.demojar.repository;

import com.example.demojar.entity.ComputerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CRepository extends JpaRepository<ComputerEntity, Long> {

    List<ComputerEntity> findAllByOrderByPriceAsc();
    List<ComputerEntity> findAllByPriceIsBefore(Long number);


}
