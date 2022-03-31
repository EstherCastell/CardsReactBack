package com.cardsReact.cardsreact.back.ModelsTest;

import com.cardsReact.cardsreact.back.Models.Categories;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class CategoriesTest {
    @Test
    void categoryHaveIdNameAndImage(){
        Categories categories = new Categories(1L, "beach", "beach");

        assertThat(categories.getId(), equalTo(1L));
        assertThat(categories.getTitle(), equalTo("beach"));
        assertThat(categories.getImgURL(), equalTo("beach"));
    }

}
