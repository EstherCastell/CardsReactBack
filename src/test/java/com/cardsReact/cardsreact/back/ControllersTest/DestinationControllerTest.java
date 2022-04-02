package com.cardsReact.cardsreact.back.ControllersTest;

import com.cardsReact.cardsreact.back.Controllers.DestinationController;
import com.cardsReact.cardsreact.back.Models.Categories;
import com.cardsReact.cardsreact.back.Models.Destination;
import com.cardsReact.cardsreact.back.Repository.DestinationRepository;
import com.cardsReact.cardsreact.back.Services.DestinationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DestinationController.class)
public class DestinationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DestinationService destinationService;
    @MockBean
    DestinationRepository destinationRepository;

    @Test
    void canSeeADestinationById() throws Exception {
        Categories categories = new Categories(1L, "beach", "beach");
        Destination destination = new Destination(1L, "beach", "beach", categories);

        when(destinationService.getById(1L)).thenReturn(destination);

        mockMvc.perform(get("/destination/"+destination.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void canCreateANewDestination() throws Exception {
        Categories categories = new Categories(1L, "beach", "beach");
        Destination destination = new Destination(3L, "castelldefels", "castelldefels", categories);

        when(destinationRepository.save(destination)).thenReturn(destination);

        mockMvc.perform(get("/destination/3"))
                .andDo(print())
                .andExpect(status().isOk());




    }
}
