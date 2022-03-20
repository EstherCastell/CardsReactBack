package com.cardsReact.cardsreact.back.Services;


import com.cardsReact.cardsreact.back.Dtos.DestinationResponseDTO;

import java.util.List;

public interface DestinationService {

    List<DestinationResponseDTO> getAllDestinations();
    DestinationResponseDTO get(Long id);
}
