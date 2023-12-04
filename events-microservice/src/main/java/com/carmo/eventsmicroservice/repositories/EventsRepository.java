package com.carmo.eventsmicroservice.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carmo.eventsmicroservice.domain.Event;

import jakarta.annotation.Nonnull;

public interface EventsRepository extends JpaRepository<Event, String>{
	
	@Query("SELECT ** FROM events e WHERE PARSE(e.date AS TIMESTAMP) > :currentDate", nativeQuery = true)  
	List<Event> findUpcomingEvents(@Param("currentDate") LocalDateTime currentDate);
	
	@Nonnull
	Optional<Event> findById(@Nonnull String id);
}
