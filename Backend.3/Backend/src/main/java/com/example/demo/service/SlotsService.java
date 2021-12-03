package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Slots;

public interface SlotsService {
	
	Slots saveSlots(Slots slot);

	Optional<Slots> getSlot(long id);

	List<Slots> getAllSlots();
	
	Slots updateSlots(Slots slot, long id, String chosenFeatures);

}
