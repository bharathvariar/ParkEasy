package com.example.demo.model;

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
@Table(name = "workers")
public class Worker {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @NotBlank
    @Column(name = "phone")
    @JsonProperty(value = "phone")
    private long phone;

    @NotBlank
    @Column(name = "isAvailable")
    @JsonProperty(value = "isAvailable")
    private boolean isAvailable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailablity(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Worker))
            return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, isAvailable);
    }

    @Override
    public String toString() {
        return "Worker [id=" + id + ", isAvailable=" + isAvailable + ", name=" + name + ", phone=" + phone + "]";
    }
    
}
