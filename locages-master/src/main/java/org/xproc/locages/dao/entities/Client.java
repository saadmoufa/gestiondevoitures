package org.xproc.locages.dao.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nbrCin;
    private String name;
    private String lastName;
    private int phoneNbr;
    private String email;
    private String drvLNbr;
    private LocalDate drvLExpD;
    private String address;

}

