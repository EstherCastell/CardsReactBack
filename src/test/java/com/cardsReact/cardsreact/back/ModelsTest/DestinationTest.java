package com.cardsReact.cardsreact.back.ModelsTest;

import com.cardsReact.cardsreact.back.Models.Destination;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

public class DestinationTest {
    @Test

    void destinationsHaveIdAndName() {
        Destination destinations = new Destination(1L,"beach", "beach");

        assertThat(destinations, hasProperty("id"));
        assertThat(destinations, hasProperty("title"));
        assertThat(destinations, hasProperty("imgURL"));
        assertThat(destinations.getTitle(), equalTo("beach"));
    }
    }
