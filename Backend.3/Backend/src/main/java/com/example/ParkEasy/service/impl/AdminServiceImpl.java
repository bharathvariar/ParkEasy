package com.example.ParkEasy.service.impl;

import java.util.List;

import com.example.ParkEasy.exception.ResourceNotFoundException;
import com.example.ParkEasy.model.Admin;
import com.example.ParkEasy.model.SlotCounter;
import com.example.ParkEasy.model.Slots;
import com.example.ParkEasy.model.Worker;
import com.example.ParkEasy.repository.AdminRepository;
import com.example.ParkEasy.repository.SlotCounterRepository;
import com.example.ParkEasy.repository.SlotsRepository;
import com.example.ParkEasy.repository.UserRepository;
import com.example.ParkEasy.repository.WorkerRepository;
import com.example.ParkEasy.service.AdminService;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private UserRepository userRepository;
    private SlotsRepository slotsRepository;
    private WorkerRepository workerRepository;
    private SlotCounterRepository slotCounterRepository;

    public AdminServiceImpl(AdminRepository adminRepository, UserRepository userRepository,
            SlotsRepository slotsRepository, WorkerRepository workerRepository,
            SlotCounterRepository slotCounterRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.slotsRepository = slotsRepository;
        this.workerRepository = workerRepository;
        this.slotCounterRepository = slotCounterRepository;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin adminLogin(Admin admin, long adminId) {
        Admin existingAdmin = adminRepository.findById(adminId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", adminId));
        existingAdmin.setLoggedIn(true);
        adminRepository.save(existingAdmin);

        return existingAdmin;
    }

    @Override
    public Status adminLogout(Admin admin, long adminId) {
        Admin existingAdmin = adminRepository.findById(adminId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", adminId));
        existingAdmin.setLoggedIn(false);
        adminRepository.save(existingAdmin);

        return Status.SUCCESS;
    }

    @Override
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }

    @Override
    public Slots saveSlots(Slots slot) {
        return slotsRepository.save(slot);
    }

    @Override
    public List<Slots> getAllSlots() {
        return slotsRepository.findAll();
    }

    @Override
    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Status deleteWorker(Worker worker) {
        workerRepository.findById(worker.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Worker", "id", worker.getId()));
        workerRepository.deleteById(worker.getId());
        return Status.SUCCESS;
    }

    @Override
    public SlotCounter saveSlotCounter(SlotCounter slotcounter) {
        return slotCounterRepository.save(slotcounter);

    }

    @Override
    public List<SlotCounter> getSlotCounter() {
        return slotCounterRepository.findAll();
    }

    @Override
    public SlotCounter updateSlotCounter(SlotCounter slotcounter,long id) {
        SlotCounter existingslotcounter = slotCounterRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("SlotCounter", "Id", id));
        existingslotcounter.setNumSlots(slotcounter.getNumSlots());
        slotCounterRepository.save(existingslotcounter);

        return existingslotcounter;
    }

    
}
