package com.carmo.eventsmicroservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carmo.eventsmicroservice.domain.Event;
import com.carmo.eventsmicroservice.dtos.EventRequestDTO;
import com.carmo.eventsmicroservice.dtos.SubscriptionRequestDTO;
import com.carmo.eventsmicroservice.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	private EventService eventService;
	
	@GetMapping
	public List<Event> getAllEvents(){
		return eventService.getAllEvents();
	}
	
	@GetMapping("/upcoming")
	public List<Event> getUpcomingEvents(){
		return eventService.getUpcomingEvents();
	}
	
	@PostMapping
	public Event createEvent(@RequestBody EventRequestDTO event) {
		return eventService.createEvent(event);
	}
	
	@PostMapping("/{eventId}/register")
	public void registerParticipant(@PathVariable String eventId, @RequestBody SubscriptionRequestDTO subscriptionRequest) {
		eventService.registerParticipants(eventId, subscriptionRequest.participantEmail());
	}
		
}
