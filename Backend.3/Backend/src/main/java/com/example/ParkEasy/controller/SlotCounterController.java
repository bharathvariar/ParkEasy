package com.example.ParkEasy.controller;

import com.example.ParkEasy.model.SlotCounter;
import com.example.ParkEasy.repository.SlotCounterRepository;
import com.example.ParkEasy.service.SlotCounterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/parkeasy/slotcount")
public class SlotCounterController {
    
    private SlotCounterService slotCounterService;

    
    public SlotCounterController(SlotCounterService slotCounterService) {
        this.slotCounterService = slotCounterService;
    }

    @Autowired
    SlotCounterRepository slotCounterRepository;

    @CrossOrigin
    @PatchMapping
    public ResponseEntity<SlotCounter> saveAdmin(@RequestBody SlotCounter slotcounter) {
        return new ResponseEntity<SlotCounter>(slotCounterService.saveSlot(slotcounter), HttpStatus.CREATED);
    }


}
