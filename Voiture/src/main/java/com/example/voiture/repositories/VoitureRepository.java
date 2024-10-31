package com.example.voiture.repositories;

import com.example.voiture.Client;
import com.example.voiture.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    List<Voiture> findByClient(Client client);
}
