package com.cardsReact.cardsreact.back.Repository;

import com.cardsReact.cardsreact.back.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
