package com.cardsReact.cardsreact.back.ControllersTest;

import com.cardsReact.cardsreact.back.Controllers.CategoriesController;
import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Services.CategoriesService;
import com.cardsReact.cardsreact.back.Services.DestinationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoriesController.class)
public class CategoriesControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoriesService categoriesService;
    @MockBean
    DestinationService destinationService;

    @Test
    void canSeeACategoryById() throws Exception{

        Categories category = new Categories(1L, "beach", "beach");
        when(categoriesService.getById(1L)).thenReturn(category);

        mockMvc.perform(get("/categories/"+category.getId()))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    void canSeeAllCategories() throws Exception{
        Categories category = new Categories();
        Categories category1 = new Categories();
        List categoriesList = new ArrayList<Categories>();
        categoriesList.add(category);
        categoriesList.add(category1);

        when(categoriesService.getAll()).thenReturn(categoriesList);

        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void canSeeADestinationListForEachCategory() throws Exception{
        Categories categories = new Categories(1L, "beach", "beach");
        Destination destination1 = new Destination(1L, "cancun", "cancun", categories);
        Destination destination2 = new Destination(2L, "sitges", "sitges", categories);
        List destinationsList = new ArrayList<Destination>();
        destinationsList.add(destination1);
        destinationsList.add(destination2);

        when(destinationService.getAllByCategories(categories)).thenReturn(destinationsList);

        mockMvc.perform(get("/categories/1/destination"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
