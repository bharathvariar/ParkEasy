package com.parkeasy.parkeasy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResourceController {

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
