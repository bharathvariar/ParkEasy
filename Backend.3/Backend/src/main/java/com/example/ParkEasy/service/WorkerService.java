package com.example.ParkEasy.service;

import java.util.List;

import com.example.ParkEasy.model.Worker;
import com.example.ParkEasy.service.impl.Status;

public interface WorkerService {

    Worker saveWorker(Worker worker);

    List<Worker> getAllWorkers();

    Status deleteWorker(Worker worker);

    Worker updateWorker(Worker Worker, long id, boolean isAvailable);

}
