package com.example.medicine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String degree;

    @JsonIgnore
    @ManyToMany(mappedBy = "doctors", fetch = FetchType.EAGER)
    private transient Set<Clinic> clinics;

    @OneToOne(mappedBy = "doctor" )
    private Appointment appointment;

}
