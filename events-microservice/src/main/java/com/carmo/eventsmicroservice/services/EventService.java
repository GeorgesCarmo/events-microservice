package com.carmo.eventsmicroservice.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmo.eventsmicroservice.domain.Event;
import com.carmo.eventsmicroservice.domain.Subscription;
import com.carmo.eventsmicroservice.dtos.EmailRequestDTO;
import com.carmo.eventsmicroservice.dtos.EventRequestDTO;
import com.carmo.eventsmicroservice.exceptions.EventFullException;
import com.carmo.eventsmicroservice.exceptions.EventNotFoundException;
import com.carmo.eventsmicroservice.repositories.EventsRepository;
import com.carmo.eventsmicroservice.repositories.SubscriptionRepository;

@Service
public class EventService {
	
	@Autowired
	private EventsRepository eventRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private EmailServiceClient emailServiceClient;
	
	public List<Event> getAllEvents(){
		return eventRepository.findAll();
	}
	
	public List<Event> getUpcomingEvents(){
		return eventRepository.findUpcomingEvents(LocalDateTime.now());
	}
	
	public Event createEvent(EventRequestDTO eventRequest) {
		Event newEvent = new Event(eventRequest);
		return eventRepository.save(newEvent);
	}
	
	private Boolean isEventFull(Event event) {
		return event.getRegisteredParticipants() >= event.getMaxParticipants();
	}
	
	public void registerParticipants(String eventId, String participantEmail) {
		Event event = eventRepository.findById(eventId).orElseThrow();
		
		if(isEventFull(event)) {
			throw new EventFullException();
	}
		
			Subscription subscription = new Subscription(event, participantEmail);
			subscriptionRepository.save(subscription);
			
			event.setRegisteredParticipants(event.getRegisteredParticipants() +1);
			
			EmailRequestDTO emailRequest = new EmailRequestDTO(participantEmail, "Confirmação de inscrição", "Você foi inscrito no evento com sucesso!");
			
			emailServiceClient.sendEmail(emailRequest);
	}
}
