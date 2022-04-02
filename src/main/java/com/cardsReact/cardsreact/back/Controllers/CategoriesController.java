package com.cardsReact.cardsreact.back.Controllers;

import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/categories")
    public List<Categories>getAll(){ return categoriesService.getAll();}


    @GetMapping("/categories/{id}")
   public ResponseEntity<Categories> getById(@PathVariable Long id) {
        try {
            Categories categories = categoriesService.getById(id);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
