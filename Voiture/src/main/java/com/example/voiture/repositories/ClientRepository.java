package com.example.voiture.repositories;

import com.example.voiture.Client;
import com.example.voiture.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
