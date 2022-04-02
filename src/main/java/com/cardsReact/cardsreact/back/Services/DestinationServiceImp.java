package com.cardsReact.cardsreact.back.Services;

import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImp implements DestinationService {


    private DestinationRepository destinationRepository;
    public DestinationServiceImp(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public List<Destination> getAllDestinations(){
        return destinationRepository.findAll();}


    @Override
    public Destination getById(Long id){
        return destinationRepository.findById(id).get();
    }


}



