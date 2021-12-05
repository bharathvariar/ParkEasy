package com.example.ParkEasy.controller;

import java.util.List;
import java.util.Optional;

import com.example.ParkEasy.model.Slots;
import com.example.ParkEasy.model.User;
import com.example.ParkEasy.service.SlotsService;

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

@RestController
@CrossOrigin
@RequestMapping("/parkeasy/slots")
public class SlotsController {

	private SlotsService slotsService;

	public SlotsController(SlotsService slotsService) {
		super();
		this.slotsService = slotsService;
	}

	@CrossOrigin
	@PostMapping
	@PutMapping
	public ResponseEntity<Slots> saveSlots(@RequestBody Slots slot) {
		return new ResponseEntity<Slots>(slotsService.saveSlots(slot), HttpStatus.CREATED);

	}

	@CrossOrigin
	@GetMapping("{id}")
	public Optional<Slots> getSlot(@PathVariable("id") long id) {
		return slotsService.getSlot(id);
	}

	@CrossOrigin
	@GetMapping("/show")
	public List<Slots> getAllslots() {
		return slotsService.getAllSlots();

	}

	@CrossOrigin
	@PutMapping("{id}/{userId}")
	public ResponseEntity<Slots> updateSlot(@PathVariable("id") long id, @PathVariable("userId") long userId,
			@RequestBody Slots slot) {

		return new ResponseEntity<Slots> (slotsService.updateSlots(slot, id, userId),
				HttpStatus.OK);

	}

}