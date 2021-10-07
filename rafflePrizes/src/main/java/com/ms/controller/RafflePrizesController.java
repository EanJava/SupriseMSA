package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ms.RandomSurpriseClient;
import com.ms.TicketClient;
import com.ms.model.Surprise;

@RestController
public class RafflePrizesController {
    @Autowired
    private RandomSurpriseClient randomSurpriseClient;

    @Autowired
    private TicketClient ticketClient;

    @GetMapping("/surprises/any")
    ResponseEntity<Surprise> seeAnySurprise(){
        return randomSurpriseClient.random();
    }

    @GetMapping("/ticket")
    ResponseEntity<String> getTicket(){
        return ticketClient.ticket();
    }
}
