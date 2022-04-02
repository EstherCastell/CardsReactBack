package com.cardsReact.cardsreact.back.Services;

import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Models.Destination;
import java.util.List;

public interface DestinationService {

    List<Destination> getAllDestinations();
    Destination getById(Long id);
    List<Destination> getAllByCategories(Categories categories);
}
