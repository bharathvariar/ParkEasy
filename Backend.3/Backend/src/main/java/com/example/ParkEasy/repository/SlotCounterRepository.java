package com.example.ParkEasy.repository;

import com.example.ParkEasy.model.SlotCounter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotCounterRepository extends JpaRepository<SlotCounter, Long> {
    
    
}
