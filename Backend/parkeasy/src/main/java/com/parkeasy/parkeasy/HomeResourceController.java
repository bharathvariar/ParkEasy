package com.parkeasy.parkeasy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResourceController {

    @Autowired
    userRepository UserRepo;

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

    @PostMapping(path = "/user", consumes = { "application/json" })
    public ResponseEntity<?> addUser(@RequestBody AuthenticationRequest AuthenticationRequest) {
        String username = AuthenticationRequest.getUsername();
        String password = AuthenticationRequest.getPassword();
        userModel user = new userModel(username, password);
        try {
            UserRepo.save(user);
        } catch (Exception e) {
            return ResponseEntity.ok(new AuthenticationResponse("Error SignIn Failed"));
        }
        
        return ResponseEntity.ok(new AuthenticationResponse("Welcome" + username));
    }
}
