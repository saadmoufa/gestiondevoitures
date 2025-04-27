package org.xproc.locages.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String EmpCin;
    private String Login;
    private String Password;
    private int numTel;
    private String Name;
    private String LastName;
    private String Email;
    @ManyToMany(mappedBy = "employees")
    private Set<Car> cars = new HashSet<>();

}
