package com.parkeasy.parkeasy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    userRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

    @PostMapping(path="/user",consumes= {"application/json"})
	public users addusers(@RequestBody users user)
	{
		repo.save(user);
		return user;
	}
}
