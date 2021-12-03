package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Worker;
import com.example.demo.service.impl.Status;

public interface WorkerService {

    Worker saveWorker(Worker worker);

    List<Worker> getAllWorkers();

    Status deleteWorker(Worker worker);

    Worker updateWorker(Worker Worker, long id, boolean isAvailable);

}
