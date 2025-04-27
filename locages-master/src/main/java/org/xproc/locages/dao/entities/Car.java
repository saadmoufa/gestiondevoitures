package org.xproc.locages.dao.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cars")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nbrPlate;
    private int kmDriven;
    private String Color;
    private Double rentPrice;
    private int nbrSeats;
    private String type;
    private boolean availability;
    private String cmodel;
    private String make;
    private double carPrice;
    private double carGains;
    @ManyToMany
    @JoinTable(
            name = "Car_Employee",
            joinColumns = @JoinColumn(name = "Cars_id"),
            inverseJoinColumns = @JoinColumn(name = "employer_id")
    )
    private Set<Employee> employees = new HashSet<>();




}