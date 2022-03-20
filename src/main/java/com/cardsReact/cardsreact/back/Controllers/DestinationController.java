package com.cardsReact.cardsreact.back.Controllers;

import com.cardsReact.cardsreact.back.Dtos.DestinationResponseDTO;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Repository.DestinationRepository;
import com.cardsReact.cardsreact.back.Services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DestinationController {

    @Autowired
    DestinationService destinationService;

    @GetMapping("/destination")
    List<DestinationResponseDTO> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/destination/{id}")
    DestinationResponseDTO get (@PathVariable Long id){
        return destinationService.get(id);
    }
}

