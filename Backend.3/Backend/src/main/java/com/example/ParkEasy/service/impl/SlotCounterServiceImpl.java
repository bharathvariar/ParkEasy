package com.example.ParkEasy.service.impl;

import com.example.ParkEasy.model.SlotCounter;
import com.example.ParkEasy.repository.SlotCounterRepository;
import com.example.ParkEasy.service.SlotCounterService;

import org.springframework.stereotype.Service;


@Service
public class SlotCounterServiceImpl implements SlotCounterService {


    public SlotCounterServiceImpl(SlotCounterRepository slotCounterRepository) {
        this.slotCounterRepository = slotCounterRepository;
    }


    private SlotCounterRepository slotCounterRepository;
    @Override
    public SlotCounter saveSlot(SlotCounter slotcounter) {
        return slotCounterRepository.save(slotcounter);
       
    }
    
}
