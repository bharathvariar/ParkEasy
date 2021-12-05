package com.example.ParkEasy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "Slots")
public class Slots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "status", nullable = false)
	@JsonProperty(value = "status")
	// -1 -> Available to use
	// 0 -> Visible to admin (under maintanance)
	// 1 -> Not available, already booked
	private int status;

	@Column(name = "time", nullable = false)
	@JsonProperty(value = "time")
	private String time;

	@Column(name = "chosenFeatures", nullable = false)
	@JsonProperty(value = "chosenFeatures")
	// 0 -> None Chosen
	// 1 -> Valet Parking
	// 2 -> Car Wash
	// 3 -> Quick Service
	private String chosenFeatures;

	@Column(name = "bookedBy", nullable = false)
	@JsonProperty(value = "bookedBy")
	private String bookedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getChosenFeatures() {
		return chosenFeatures;
	}

	public void setChosenFeatures(String chosenFeatures) {
		this.chosenFeatures = chosenFeatures;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		if (bookedBy == "") {
			this.bookedBy = bookedBy;
		} else {
			this.bookedBy = this.bookedBy + "-" + bookedBy;
		}
	}

}
