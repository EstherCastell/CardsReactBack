package com.cardsReact.cardsreact.back.ServiceTest;

import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Repository.DestinationRepository;
import com.cardsReact.cardsreact.back.Services.DestinationService;
import com.cardsReact.cardsreact.back.Services.DestinationServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class DestinationServiceTest {
    @Mock
    DestinationService destinationService;

    @Mock
    private DestinationRepository destinationRepository;

    @Test
    void canGetAllDestinationsList(){
        var destination1 = new Destination(1L, "beach", "beach");
        var destination2 = new Destination(2L, "mountain", "mountain");
        List<Destination>destinationList = new ArrayList<>();
        destinationList.add(destination1);
        destinationList.add(destination2);
/*
        for (Destination destination : destinationList
             ) {destination.getTitle();
            destinationList.add(destination);

        }*/

        Mockito.when(destinationRepository.findAll()).thenReturn(destinationList);

        var destinationServiceImp = new DestinationServiceImp(destinationRepository);

        var sut = destinationService.getAllDestinations();

        //assertEquals(destinationList.size(), sut.size());
        assertThat(destinationList.size(), equalTo(2));
    }
}
