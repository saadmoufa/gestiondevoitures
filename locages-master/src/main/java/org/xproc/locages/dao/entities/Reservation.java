package org.xproc.locages.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate DateDebut;
    private String LocHand;//location of handing the car
    private LocalDate DateEnd;
    private String LocTB;//location to take back the car
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_id") // This is the foreign key column in the Reservations table
    private Client client; // Reference to the Client class

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Car_id") // This is the foreign key column in the Reservations table
    private Car car; // Reference to the Car class
}