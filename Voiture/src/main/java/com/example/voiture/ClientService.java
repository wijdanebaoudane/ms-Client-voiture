package com.example.voiture;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {

    @GetMapping(path = "/client/{id}") // Point de terminaison dans le service-client
    Client clientById(@PathVariable("id") Long id); // Récupérer un client par son ID
}
