package com.example.parkeasy.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.parkeasy.Model.UserRole;
import com.example.parkeasy.Model.UserModel;
import com.example.parkeasy.Repository.UserRepository;
import com.example.parkeasy.Web.DTO.UserRegistrationDTO;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserModel save(UserRegistrationDTO registrationDTO) {
        UserModel userModel = new UserModel(registrationDTO.getFirstName(), registrationDTO.getLastName(), registrationDTO.getEmail(),
                passwordEncoder.encode(registrationDTO.getPassword()), Arrays.asList(new UserRole("ROLE_USER")));

        return userRepository.save(userModel);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userRepository.findByEmail(username);
        if (userModel == null) {
            throw new UsernameNotFoundException("Invalid Username or Password.");
        }
        return new org.springframework.security.core.userdetails.User(userModel.getEmail(), userModel.getPassword(),
                mapRolesToAuthorities(userModel.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}