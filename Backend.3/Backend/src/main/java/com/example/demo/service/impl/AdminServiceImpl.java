package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.model.Slots;
import com.example.demo.model.Worker;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.SlotsRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.service.AdminService;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private UserRepository userRepository;
    private SlotsRepository slotsRepository;
    private WorkerRepository workerRepository;

    public AdminServiceImpl(AdminRepository adminRepository, UserRepository userRepository,
            SlotsRepository slotsRepository, WorkerRepository workerRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.slotsRepository = slotsRepository;
        this.workerRepository = workerRepository;
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
    public Status deleteWorker(Worker worker) {
        workerRepository.findById(worker.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Worker", "id", worker.getId()));
        workerRepository.deleteById(worker.getId());
        return Status.SUCCESS;
    }

}
