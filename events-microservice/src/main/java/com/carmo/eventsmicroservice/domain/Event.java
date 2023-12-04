package com.carmo.eventsmicroservice.domain;

import com.carmo.eventsmicroservice.dtos.EventRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Table(name = "event")
@EqualsAndHashCode(of = "id")
@Entity(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private int maxParticipants;
	private int registeredParticipants;
	private String date;
	private String title;
	private String description;
	
	public Event(EventRequestDTO eventRequest) {
		this.date = eventRequest.date();
		this.maxParticipants = eventRequest.maxParticipants();
		this.registeredParticipants = eventRequest.registeredParticipants();
		this.title = eventRequest.title();
		this.description = eventRequest.description();
	}
	
	public Event() {
	}

	public Event(String id, int maxParticipants, int registeredParticipants, String date, String title,
			String description) {
		this.id = id;
		this.maxParticipants = maxParticipants;
		this.registeredParticipants = registeredParticipants;
		this.date = date;
		this.title = title;
		this.description = description;
	}

	public int getRegisteredParticipants() {
		return registeredParticipants;
	}

	public void setRegisteredParticipants(int registeredParticipants) {
		this.registeredParticipants = registeredParticipants;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
