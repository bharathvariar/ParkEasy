package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.service.WorkerService;

import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

    private WorkerRepository workerRepository;
    
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        super();
        this.workerRepository = workerRepository;
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
    public Worker updateWorker(Worker worker, long id, boolean isAvailable) {
        
        Worker existingWorker = workerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id));
        if (isAvailable == true) {
            existingWorker.setAvailablity(true);
        }
        else {
            existingWorker.setAvailablity(false);
        }

        workerRepository.save(existingWorker);
        return existingWorker;
    }
    
}
