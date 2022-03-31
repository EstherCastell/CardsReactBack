/*package com.cardsReact.cardsreact.back.ServiceTest;

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

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class DestinationServiceTest {
    @Mock
    DestinationService destinationService;
    @Test
    void canGetAllDestinationsList(){
        Destination destination = new Destination();
        Destination destination1 = new Destination();
        List<Destination>destinationList = new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination1);

        Mockito.when(destinationService.getAllDestinations().get(destinationList.size()));

        //DestinationServiceImp destinationServiceImp = new DestinationServiceImp();

        var sut = destinationService.getAllDestinations();

        assertEquals(destinationList.size(), sut.size());
    }
}*/
