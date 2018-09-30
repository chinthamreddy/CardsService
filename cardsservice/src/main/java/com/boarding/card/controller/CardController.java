package com.boarding.card.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boarding.card.cardrepository.CardRepository;
import com.boarding.card.model.Card;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/card")
public class CardController {

	@Autowired
	CardRepository cardRepository;
	
	@PostMapping("/savecard")
	public Card createCard(@Valid @RequestBody Card card) {
		return cardRepository.save(card);
	}
	
	@GetMapping("/getallcards")
	public List<Card> getAllCards(){
		return cardRepository.findAll();
	}
	
	@GetMapping("/getcarddetails/{cardNumber}")
	public Optional<Card> getCard(@PathVariable("cardNumber") Long cardNumber) {
		return cardRepository.findById(cardNumber);
	}
	
	@DeleteMapping(path = "/deletecard/{cardNumber}")
    public void delete(@PathVariable("cardNumber") Long CARD_NUMBER) {
        cardRepository.deleteById(CARD_NUMBER);
    }
	
	 @PutMapping(path = "/updatecard/{cardNumber}")
	    public Card updateCard(@PathVariable("cardNumber") Long CARD_NUMBER, @RequestBody Card card) throws BadHttpRequest {
	        if (cardRepository.existsById(CARD_NUMBER)) {
	            card.setFirstName(card.getFirstName());
	            card.setLast_name(card.getLast_name());
	            card.setAddressLine1(card.getAddressLine1());
	            card.setAddressLine2(card.getAddressLine2());
	            card.setCity(card.getCity());
	            card.setState(card.getState());
	            card.setZipcode(card.getZipcode()); 
	            return cardRepository.save(card);
	        } else {
	            throw new BadHttpRequest();
	        }
	    }
	
	
}
