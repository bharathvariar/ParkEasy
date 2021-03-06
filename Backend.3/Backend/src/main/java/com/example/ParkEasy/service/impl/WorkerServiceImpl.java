package com.example.ParkEasy.service.impl;

import java.util.List;

import com.example.ParkEasy.exception.ResourceNotFoundException;
import com.example.ParkEasy.model.Worker;
import com.example.ParkEasy.repository.WorkerRepository;
import com.example.ParkEasy.service.WorkerService;

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
                () -> new ResourceNotFoundException("Worker", "Id", id));
        existingWorker.setAvailablity(worker.isAvailable());
        workerRepository.save(existingWorker);
        return existingWorker;
    }

    @Override
    public Status deleteWorker(Worker worker) {
        workerRepository.findById(worker.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Worker", "id", worker.getId()));
        workerRepository.deleteById(worker.getId());
        return Status.SUCCESS;
    }
}
