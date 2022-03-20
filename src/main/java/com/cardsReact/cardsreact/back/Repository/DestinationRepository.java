package com.cardsReact.cardsreact.back.Repository;

import com.cardsReact.cardsreact.back.Models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
