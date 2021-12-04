package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Admin;
import com.example.demo.model.Slots;
import com.example.demo.model.Worker;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.SlotsRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.service.impl.Status;
import com.example.demo.service.AdminService;

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
    @DeleteMapping("/worker/delete/{id}")
    public String deleteWorker(@PathVariable long id) {
        Worker worker = workerRepository.getOne(id);
        workerRepository.delete(worker);
        return "DELETED";
    }

}