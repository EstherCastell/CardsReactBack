package com.cardsReact.cardsreact.back.ServiceTest;

import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Services.CategoriesService;
import com.cardsReact.cardsreact.back.Services.DestinationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class DestinationServiceTest {
    @Mock
    DestinationService destinationService;

    @Test
    void canSeeAllCategories(){
        Categories categories = new Categories();
        ArrayList<Destination> destinationArrayList = new ArrayList<>();
        destinationArrayList.add(new Destination(1L, "beach", "beach",categories));
        destinationArrayList.add(new Destination(2L, "mountain", "mountain", categories));

        Mockito.when(destinationService.getAllDestinations()).thenReturn(destinationArrayList);
        var sut = destinationService.getAllDestinations();

        assertEquals(destinationArrayList.size(), sut.size());
        assertEquals(destinationArrayList.get(0).getTitle(), sut.get(0).getTitle());
        assertThat(destinationArrayList.get(0).getTitle(), equalTo("beach"));
    }

    /*@Test

    void CanCreateANewDestination(){
        Long id = 3L;
        String title = "Beach";
        String imgURL = "Beach";
        Categories categories;

        Destination mockedDestination = new Destination
                .builder()

    }*/



}
