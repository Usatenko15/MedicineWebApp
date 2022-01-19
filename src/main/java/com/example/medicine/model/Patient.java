package com.example.medicine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String dateBirth;

    @JsonIgnore
    @OneToOne(mappedBy = "patient")
    private Appointment appointment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Clinic clinic;
}
