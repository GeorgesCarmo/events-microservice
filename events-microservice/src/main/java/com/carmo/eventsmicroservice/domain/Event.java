package com.carmo.eventsmicroservice.domain;

import com.carmo.eventsmicroservice.dtos.EventRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
		this.setMaxParticipants(eventRequest.maxParticipants());
		this.setRegisteredParticipants(eventRequest.registeredParticipants());
		this.title = eventRequest.title();
		this.description = eventRequest.description();
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
}
