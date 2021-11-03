package com.parkeasy.parkeasy;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class users {
    @Id
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword_check() {
        return password_check;
    }
    public void setPassword_check(String password_check) {
        this.password_check = password_check;
    }
    // public userAddress getAddress() {
    //     return address;
    // }
    // public void setAddress(userAddress address) {
    //     this.address = address;
    //}
    public String getEmail_id() {
        return email_id;
    }
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
    public int getMobile() {
        return mobile;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public String getCar_number() {
        return Car_number;
    }
    public void setCar_number(String car_number) {
        Car_number = car_number;
    }
    private String username;
    private String password;
    private String password_check;
    //private userAddress address;
    private String email_id;
    private int mobile;
    @Override
    public String toString() {
        return "users [Car_number=" + Car_number + " , email_id=" + email_id + ", id=" + id
                + ", mobile=" + mobile + ", password=" + password + ", password_check=" + password_check + ", username="
                + username + "]";
    }
    private String Car_number;

    
}
