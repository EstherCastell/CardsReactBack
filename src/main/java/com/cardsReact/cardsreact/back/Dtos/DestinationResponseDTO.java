package com.cardsReact.cardsreact.back.Dtos;

import com.cardsReact.cardsreact.back.Models.Destination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationResponseDTO {
    public Long id;
    public String title;
    public String imgURL;

    public DestinationResponseDTO mapFromDestination(Destination destination){
        this.id = destination.getId();
        this.title = destination.getTitle();
        this.imgURL = destination.getImgURL();

        return this;

    }

}
