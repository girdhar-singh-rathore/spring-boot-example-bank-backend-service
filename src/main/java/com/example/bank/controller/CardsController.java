package com.example.bank.controller;

import com.example.bank.model.Cards;
import com.example.bank.model.Customer;
import com.example.bank.repository.CardsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:36 AM
 */

@RestController
public class CardsController {

    private CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @PostMapping("/cards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getId());
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
