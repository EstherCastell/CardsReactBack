package com.cardsReact.cardsreact.back.ControllersTest;

import com.cardsReact.cardsreact.back.Controllers.CategoriesController;
import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Services.CategoriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
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

    @Test
    void canSeeACategoryById() throws Exception{

        Categories category = new Categories(1L, "beach", "beach");
        when(categoriesService.get(1L)).thenReturn(category);

        mockMvc.perform(get("/categories/"+category.getId()))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
