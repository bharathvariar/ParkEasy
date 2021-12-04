package com.example.ParkEasy.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.example.ParkEasy.service.impl.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/parkeasy/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SlotsRepository slotsRepository;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    SlotCounterRepository slotCounterRepository;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @CrossOrigin
    @PostMapping
    @PutMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PatchMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@Valid @RequestBody Admin admin) {

        List<Admin> admins = adminRepository.findAll();

        for (Admin other : admins) {
            if (other.equals(admin)) {
                return new ResponseEntity<Admin>(adminService.adminLogin(other, other.getAdminId()), HttpStatus.OK);
            }
        }

        return null;
    }

    @CrossOrigin
    @PatchMapping("/logout")
    public Status logoutAdmin(@Valid @RequestBody Admin admin) {

        List<Admin> admins = adminRepository.findAll();

        for (Admin other : admins) {
            if (other.equals(admin)) {

                return (adminService.adminLogout(other, other.getAdminId()));
            }
        }

        return Status.FAILURE;
    }

    @CrossOrigin
    @DeleteMapping("/user/deleteall")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }

    @CrossOrigin
    @PostMapping("/slots/add")
    @PutMapping("/slots/add")
    public ResponseEntity<Slots> saveSlots(@RequestBody Slots slot) {
        return new ResponseEntity<Slots>(adminService.saveSlots(slot), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/slots/show")
    public List<Slots> getAllslots() {
        return adminService.getAllSlots();
    }

    @PostMapping("/worker/add")
    @PutMapping("/worker/add")
    public ResponseEntity<Worker> saveWorker(@Valid @RequestBody Worker newWorker) {

        List<Worker> workers = workerRepository.findAll();

        for (Worker worker : workers) {
            if (worker.equals(newWorker)) {
                System.out.println("Worker Already exists!");
                return null;
            }
        }
        workerRepository.save(newWorker);
        return new ResponseEntity<Worker>(adminService.saveWorker(newWorker), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/worker/show")
    public List<Worker> getAllWorkers() {
        return adminService.getAllWorkers();
    }

    @CrossOrigin
    @DeleteMapping("/worker/delete/{id}")
    public String deleteWorker(@PathVariable long id) {
        Worker worker = workerRepository.getOne(id);
        workerRepository.delete(worker);
        return "DELETED";
    }

    @CrossOrigin
    @PostMapping("/slotcounter")
    public ResponseEntity<SlotCounter> saveSlotCounter(@RequestBody SlotCounter slotcounter) {
        return new ResponseEntity<SlotCounter>(adminService.saveSlotCounter(slotcounter), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PatchMapping("/slotcounter/{id}")
    public ResponseEntity<SlotCounter> updateSlotCounter(@RequestBody SlotCounter slotCounter,
            @PathVariable ("id") long id) {
        
        List<SlotCounter> slotCounterList = slotCounterRepository.findAll();

        for (SlotCounter other : slotCounterList) {
            if (other.equals(slotCounter)) {
                return new ResponseEntity<SlotCounter>(adminService.updateSlotCounter(slotCounter, id), HttpStatus.OK);
            }
        }
        return null;
    }
}