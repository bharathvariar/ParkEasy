package com.example.parkeasy.Service;

import com.example.parkeasy.Model.UserModel;
import com.example.parkeasy.Web.DTO.UserRegistrationDTO;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserModel save(UserRegistrationDTO registrationDTO);
}