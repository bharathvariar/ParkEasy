package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Slots;

public interface SlotsService {
	
	Slots saveSlots(Slots slot);

	List<Slots> getAllSlots();

	Slots updateSlots(Slots slot, long id);

}
