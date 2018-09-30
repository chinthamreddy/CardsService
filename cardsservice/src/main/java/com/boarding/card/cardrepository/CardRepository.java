package com.boarding.card.cardrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boarding.card.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

	
}
