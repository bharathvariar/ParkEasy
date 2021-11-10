package com.parkeasy.parkeasy;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class userModel {

    @Id
    private String id;
    private String username;
    private String password;
    private String passwordCheck;
    private userAddress address;
    private String email;
    private long mobile;
    private String CarNumber;

    public userModel() {
        // Default constructor
    }

    public userModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
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

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public userAddress getAddress() {
        return address;
    }

    public void setAddress(userAddress address) {
        this.address = address;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String CarNumber) {
        this.CarNumber = CarNumber;
    }

    @Override
    public String toString() {
        return "users [CarNumber=" + CarNumber + ", address=" + address + ", email=" + email + ", mobile=" + mobile
                + ", password=" + password + ", passwordCheck=" + passwordCheck + ", username=" + username + "]";
    }

}
