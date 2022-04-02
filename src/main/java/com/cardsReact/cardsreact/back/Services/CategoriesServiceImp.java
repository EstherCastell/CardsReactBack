package com.cardsReact.cardsreact.back.Services;

import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Repository.CategoriesRepository;
import com.cardsReact.cardsreact.back.Repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImp implements CategoriesService {

    private CategoriesRepository categoriesRepository;
    public CategoriesServiceImp(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;}

    @Override
    public Categories get(Long id){ return categoriesRepository.findById(id).get();}
}
