package com.carmo.eventsmicroservice.exceptions;

public class EventFullException extends RuntimeException{

	public EventFullException() {
		super("Não foi possível concluir a inscrição. O evento está lotado!");
	}
	
	public EventFullException(String message) {
		super(message);
	}
}
