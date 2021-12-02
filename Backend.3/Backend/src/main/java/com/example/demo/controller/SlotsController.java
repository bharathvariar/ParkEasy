package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Slots;
import com.example.demo.service.SlotsService;

@RestController
@CrossOrigin
@RequestMapping("/parkeasy/slots")
public class SlotsController {
	
	private SlotsService slotsService;

	public SlotsController(SlotsService slotsService) {
		super();
		this.slotsService = slotsService;
	}

	@PostMapping
	@PutMapping
	public ResponseEntity<Slots> saveSlots(@RequestBody Slots slot) {
		return new ResponseEntity<Slots>(slotsService.saveSlots(slot), HttpStatus.CREATED);

	}

	@GetMapping
	public List<Slots> getAllslots() {
		return slotsService.getAllSlots();

	}

	@CrossOrigin
	@PutMapping("{id}")
	public ResponseEntity<Slots> updateSlot(@PathVariable("id") long id, @RequestBody Slots slot) {
		return new ResponseEntity<Slots>(slotsService.updateSlots(slot, id), HttpStatus.OK);

	}
}