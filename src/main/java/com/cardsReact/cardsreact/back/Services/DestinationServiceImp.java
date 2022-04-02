package com.cardsReact.cardsreact.back.Services;

import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Repository.CategoriesRepository;
import com.cardsReact.cardsreact.back.Repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImp implements DestinationService {


    private DestinationRepository destinationRepository;
    private CategoriesRepository categoriesRepository;
    public DestinationServiceImp(DestinationRepository destinationRepository, CategoriesRepository categoriesRepository) {
        this.destinationRepository = destinationRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<Destination> getAllDestinations(){
        return destinationRepository.findAll();}


    @Override
    public Destination getById(Long id){
        return destinationRepository.findById(id).get();
    }

    @Override
    public List<Destination> getAllByCategories(Categories categories){
        return destinationRepository.findAllByCategories(categories);

    }

    @Override
    public Destination createDestination(Destination destination){
       /* destination.setId(destination.getId());
        destination.setTitle(destination.getTitle());
        destination.setImgURL(destination.getImgURL());
        destination.setCategories(destination.getCategories())*/;
        return destinationRepository.save(destination);
    }
}



