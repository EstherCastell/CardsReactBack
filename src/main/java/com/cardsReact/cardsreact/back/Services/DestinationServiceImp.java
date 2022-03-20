package com.cardsReact.cardsreact.back.Services;

import com.cardsReact.cardsreact.back.Dtos.DestinationResponseDTO;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DestinationServiceImp implements DestinationService {
    @Autowired
    DestinationRepository destinationRepository;

    @Override
    public List<DestinationResponseDTO> getAllDestinations(){
        //trae la lista del repositorio
        List<Destination> destinations = destinationRepository.findAll();
        //Crea una nueva lista con el Dto
        List<DestinationResponseDTO> destinationDTOS = new ArrayList<>();
        // se recogen los datos
        for (Destination destination : destinations) {
            DestinationResponseDTO destinationResponseDTO = new DestinationResponseDTO();
            destinationResponseDTO.setId(destination.getId());
            destinationResponseDTO.setTitle(destination.getTitle());
            destinationResponseDTO.setImgURL(destination.getImgURL());
            //los añade a la nueva lista
            destinationDTOS.add(destinationResponseDTO);
        }
        return destinationDTOS;
    }


    @Override
    public DestinationResponseDTO get(Long id){
        var destinationOptional = destinationRepository.findById(id);
        var destination = destinationOptional.get();
        var destinationDto = new DestinationResponseDTO().mapFromDestination(destination);
        return destinationDto;
    }

}



