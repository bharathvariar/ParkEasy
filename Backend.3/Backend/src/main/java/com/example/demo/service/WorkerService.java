package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Worker;

public interface WorkerService {

    Worker saveWorker(Worker worker);

    List<Worker> getAllWorkers();

    Worker updateWorker(Worker Worker, long id, boolean newAvailability);

}
