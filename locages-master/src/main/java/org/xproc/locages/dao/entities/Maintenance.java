package org.xproc.locages.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate; // Updated import
import java.time.LocalDateTime; // Updated import
import java.util.Date;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type; // Updated variable name
    private LocalDate date; // Updated variable type
    private Double maintenancePrice; // Updated variable name
    private String description; // Updated variable name

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Car_id") // This is the foreign key column in the Maintenance table
    private Car car;
}
