package com.example.ParkEasy.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.ParkEasy.exception.ResourceNotFoundException;
import com.example.ParkEasy.model.Slots;
import com.example.ParkEasy.model.User;
import com.example.ParkEasy.repository.SlotsRepository;
import com.example.ParkEasy.repository.UserRepository;
import com.example.ParkEasy.service.SlotsService;

@Service
public class SlotsServiceImpl implements SlotsService {
	
	private SlotsRepository slotsRepository;
	private UserRepository userRepository;

	public SlotsServiceImpl(SlotsRepository slotsRepository, UserRepository userRepository) {
		super();
		this.slotsRepository = slotsRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Slots saveSlots(Slots slot) {
		return slotsRepository.save(slot);
	}

	@Override
	public Optional<Slots> getSlot(long id) {
		return slotsRepository.findById(id);
	}

	@Override
	public List<Slots> getAllSlots() {
		return slotsRepository.findAll();

	}

	@Override
	public Slots updateSlots(Slots slot, long id, long userId) {
		Slots existingSlot = slotsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Slots", "Id", id));
		User existingUser = userRepository.findById(userId).orElseThrow(
			() -> new ResourceNotFoundException("User", "id", userId));
		existingSlot.setStatus(slot.getStatus());
		existingSlot.setTime(slot.getTime());
		existingSlot.setChosenFeatures(slot.getChosenFeatures());
		existingSlot.setBookedBy(String.valueOf(existingUser.getId()));
		slotsRepository.save(existingSlot);
		return existingSlot;
	}

}