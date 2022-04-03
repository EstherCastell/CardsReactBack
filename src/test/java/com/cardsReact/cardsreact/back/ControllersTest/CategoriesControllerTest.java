package com.cardsReact.cardsreact.back.ControllersTest;

import com.cardsReact.cardsreact.back.Controllers.CategoriesController;
import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Services.CategoriesService;
import com.cardsReact.cardsreact.back.Services.DestinationService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CategoriesController.class)
public class CategoriesControllerTest {
    //simula las llamadas al controlador
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
                // testea que sea status 200 pero no que hayan datos
                .andExpect(status().isOk())
                // testea que traiga el id y el title en json de la category creada
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.title", Matchers.equalTo("beach")));

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
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));


    }
    @Test
    void canSeeADestinationListForEachCategory() throws Exception{
        Categories categories = new Categories(1L, "beach", "beach");
        Destination destination1 = new Destination(1L, "cancun", "cancun", categories);
        Destination destination2 = new Destination(2L, "sitges", "sitges", categories);

        List destinationsList = new ArrayList<Destination>(Arrays.asList(destination1, destination2));

        when(destinationService.getAllByCategories(categories)).thenReturn(destinationsList);

        mockMvc.perform(get("/categories/1/destination"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(jsonPath("$[0].title", Matchers.equalTo("cancun")))
    }
}
