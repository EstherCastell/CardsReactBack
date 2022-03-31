package com.cardsReact.cardsreact.back.Controllers;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class DestinationController {

    @Autowired
    DestinationService destinationService;

    @GetMapping("/destination")
    List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/destination/{id}")
    Destination getById (@PathVariable Long id){
        return destinationService.getById(id);
    }
}

