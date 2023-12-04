package com.carmo.eventsmicroservice.exceptions;

public class EventNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8381900411564470671L;

	public EventNotFoundException() {
		super("Event not found!");
	}
	
	public EventNotFoundException(String message) {
		super(message);
	}
}
