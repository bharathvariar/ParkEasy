package com.example.parkeasy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResourceController {
    
    @Autowired
    private UserRepository repository;
 
    @PostMapping("/adduser")
    public String adduser(@RequestBody UserModel user )
    {
        repository.save(user);
        return "registered user with id:" + user.getId();
    }
 
    @GetMapping("/findusers")
    public List<UserModel> getuser()
    {
        return repository.findAll();
    }
    
    @GetMapping("/")
    // Accessible by everyone
    public String Home() {
        return "<h1> Welcome </h1>";
    }
 
    @GetMapping("/user")
    // Accessible only by USER and ADMIN roles
    public String User() {
        return "<h1> Welcome User </h1>";
    }
 
    @GetMapping("/admin")
    // Accessible only by ADMIN roles
    public String Admin() {
        return "<h1> Welcome Admin </h1>";
    }
}