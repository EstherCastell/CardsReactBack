package com.cardsReact.cardsreact.back.Services;

import com.cardsReact.cardsreact.back.Models.Categories;

import java.util.List;

public interface CategoriesService {

  Categories getById(Long id);
  List<Categories> getAll();
}
