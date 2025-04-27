package org.xproc.locages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xproc.locages.dao.entities.Car;
import org.xproc.locages.dao.entities.Maintenance;
import org.xproc.locages.dao.repositories.CarRepository;
import org.xproc.locages.dao.repositories.MaintenanceRepository;
import org.xproc.locages.metier.CarManager;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class LocagesApplication implements CommandLineRunner {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MaintenanceRepository maintenanceRepository;


    public static void main(String[] args) {
        SpringApplication.run(LocagesApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Car and maintenance record added.");
    }

}

