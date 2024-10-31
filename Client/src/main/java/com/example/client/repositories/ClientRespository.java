package com.example.client.repositories;

import com.example.client.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRespository extends JpaRepository<Client,Long> {
    @Bean
    default CommandLineRunner initialiserBaseH2(ClientRespository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "Rabab"," selimani",Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"), "Amal ","Rami",Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"), "Samir ","Safi",Float.parseFloat("22")));
        };
    }
}
