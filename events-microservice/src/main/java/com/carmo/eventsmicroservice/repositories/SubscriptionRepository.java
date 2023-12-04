package com.carmo.eventsmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carmo.eventsmicroservice.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
