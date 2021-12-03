package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;
import com.example.demo.model.Slots;
import com.example.demo.model.Worker;
import com.example.demo.service.impl.Status;

public interface AdminService {
    
    Admin saveAdmin(Admin admin);
    
    Status deleteUsers();

    Slots saveSlots(Slots slot);
    
    List<Slots> getAllSlots();

    Worker saveWorker(Worker worker);
    
    Status deleteWorker(Worker worker);

}
