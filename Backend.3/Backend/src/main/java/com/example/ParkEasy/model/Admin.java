package com.example.ParkEasy.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Column(name = "adminId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;

    @NotBlank
    @Column(name = "password")
    @JsonProperty(value = "password")
    private String password;

    @NotBlank
    @Column(name = "isLoggedIn")
    @JsonProperty(value = "isLoggeddIn")
    private boolean isLoggedIn;

    public Admin() {
    }

    public Admin(long adminId, @NotBlank String password) {
        this.adminId = adminId;
        this.password = password;
        this.isLoggedIn = false;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Admin))
            return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, password, isLoggedIn);
    }

}
