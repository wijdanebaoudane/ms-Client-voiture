package com.example.voiture;

import com.example.voiture.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String matricule;
    private String model;

    @ManyToOne // Relation plusieurs-à-un avec Client
    @JoinColumn(name = "client_id") // Colonne de liaison
    private Client client; // Attribut client nécessaire pour le mapping bidirectionnel


}