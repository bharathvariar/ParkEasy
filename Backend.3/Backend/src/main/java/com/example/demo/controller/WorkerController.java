package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.service.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkeasy/worker")
public class WorkerController {

    private WorkerService workerService;
    @Autowired
    WorkerRepository workerRepository;
    
    public WorkerController(WorkerService workerService) {
        super();
        this.workerService = workerService;
    }

    @PostMapping
    @PutMapping
    public ResponseEntity<Worker> saveWorker(@RequestBody Worker worker) {
        return new ResponseEntity<>(workerService.saveWorker(worker), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }
    
    @CrossOrigin
    @PutMapping("{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") long id,
            boolean isAvailable, @RequestBody Worker worker) {
        return new ResponseEntity<Worker>(workerService.updateWorker(worker, id, isAvailable), HttpStatus.OK);

    }
    
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public String deleteWorker(@PathVariable long id) {
        Worker worker = workerRepository.getOne(id);
        workerRepository.delete(worker);
        return "DELETED";
    }
    
}
