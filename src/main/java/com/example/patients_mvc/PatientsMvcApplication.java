package com.example.patients_mvc;

import com.example.patients_mvc.entities.Patient;
import com.example.patients_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    //@Bean //permet d inserer a chaque fois (executer a chaque fois command linner)
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Houda", new Date(), true, 110));
            patientRepository.save(new Patient(null, "Mohamed", new Date(), false, 150));
            patientRepository.save(new Patient(null, "Selma", new Date(), false, 180));
            patientRepository.save(new Patient(null, "Salim", new Date(), true, 450));
            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        };
    }
}
