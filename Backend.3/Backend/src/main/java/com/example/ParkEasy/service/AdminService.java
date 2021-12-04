package com.example.ParkEasy.service;

import java.util.List;

import com.example.ParkEasy.model.Admin;
import com.example.ParkEasy.model.Slots;
import com.example.ParkEasy.model.Worker;
import com.example.ParkEasy.service.impl.Status;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    Admin adminLogin(Admin admin, long adminId);

    Status adminLogout(Admin admin, long adminId);

    Status deleteUsers();

    Slots saveSlots(Slots slot);

    List<Slots> getAllSlots();

    Worker saveWorker(Worker worker);

    Status deleteWorker(Worker worker);

}
