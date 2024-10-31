package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {
    @Bean
    CommandLineRunner initialiserBaseH2(ClientRespository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "Rabab"," selimani",Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"), "Amal ","Rami",Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"), "Samir ","Safi",Float.parseFloat("22")));
        };
    }
    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);

    }

}
