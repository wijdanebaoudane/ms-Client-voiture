package com.example.client.controllers;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRespository clientRespository;
    @GetMapping("/clients")
    public List<Client> findAll(){
        return clientRespository.findAll();
    }
    @GetMapping("/client/{id}")
    public Client findById(@PathVariable Long id) throws Exception{
        return this.clientRespository.findById(id).orElseThrow(()->new Exception("Client inexistant"));
    }

}
