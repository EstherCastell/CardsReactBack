package com.cardsReact.cardsreact.back.ServiceTest;

import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Services.CategoriesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;


@SpringBootTest
public class CategoriesServiceTest {
    @Mock
    CategoriesService categoriesService;

    @Test
    void canSeeAllCategories(){
        ArrayList<Categories> categoriesArrayList = new ArrayList<>();
        categoriesArrayList.add(new Categories(1L, "beach", "beach"));
        categoriesArrayList.add(new Categories(2L, "mountain", "mountain"));

        Mockito.when(categoriesService.getAll()).thenReturn(categoriesArrayList);
        var sut = categoriesService.getAll();

        assertEquals(categoriesArrayList.size(), sut.size());
        assertEquals(categoriesArrayList.get(0).getTitle(), sut.get(0).getTitle());
        assertThat(categoriesArrayList.get(0).getTitle(), equalTo("beach"));
    }


}
