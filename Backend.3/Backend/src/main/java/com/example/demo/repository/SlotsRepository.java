package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Slots;


public interface SlotsRepository extends JpaRepository<Slots, Long> {

}
