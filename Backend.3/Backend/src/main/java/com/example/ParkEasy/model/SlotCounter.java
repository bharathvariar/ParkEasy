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
@Table(name = "slotcounter")
public class SlotCounter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "NumSlots")
    @JsonProperty(value = "NumSlots")
    private int numSlots;

    public SlotCounter() {
    }

    public SlotCounter(@NotBlank int numSlots) {
        this.numSlots = numSlots;
    }

    public long getId() {
        return id;
    }
    
    public int getNumSlots() {
        return numSlots;
    }

    public void setNumSlots(int numSlots) {
        this.numSlots = numSlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SlotCounter))
            return false;
        SlotCounter slotCounter  = (SlotCounter) o;
        return Objects.equals(id, slotCounter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numSlots);
    }
    
}
