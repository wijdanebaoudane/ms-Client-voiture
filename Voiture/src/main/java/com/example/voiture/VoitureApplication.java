package com.example.voiture;

import com.example.voiture.repositories.ClientRepository;
import com.example.voiture.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@SpringBootApplication
public class VoitureApplication {
	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService, ClientRepository clientRepository) {
		return args -> {
			Client c1 = clientService.clientById(1L);
			Client c2 = clientService.clientById(2L);
			Client c3 = clientService.clientById(3L);
			System.out.println("**********");
			System.out.println("Id  est  :"  +  c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**********");
			System.out.println("**********");
			System.out.println("Id  est  :"  +  c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("Age est :" + c1.getAge());
			System.out.println("**********");
			System.out.println("c1 fetched from ClientService: " + c1);

			// Now use the 'client' property to set the client relationship
			voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25  333", "Corolla", clientRepository.save(c1))); // No need for 'id_client'
			voitureRepository.save(new Voiture(Long.parseLong("2"), "Renault", "B  6  3456", "Megane", clientRepository.save(c2)));
			voitureRepository.save(new Voiture(Long.parseLong("3"), "Peugeot", "A  55  4444", "301", clientRepository.save(c3))); // No need for 'id_client'

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}

}
