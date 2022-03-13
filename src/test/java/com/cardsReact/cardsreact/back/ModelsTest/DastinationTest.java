package com.cardsReact.cardsreact.back.ModelsTest;

import com.cardsReact.cardsreact.back.Models.Destinations;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

public class DastinationTest {
    @Test

    void destinationsHaveIdAndName() {
        Destinations destinations = new Destinations(1L,"beach");

        assertThat(destinations, hasProperty("id"));
        assertThat(destinations, hasProperty("title"));
        assertThat(destinations.getTitle(), equalTo("beach"));
    }
    }
