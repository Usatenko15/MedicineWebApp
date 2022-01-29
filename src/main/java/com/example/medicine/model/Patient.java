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
    private Long id;

    private String name;

    private String dateBirth;

    @JsonIgnore
    @OneToOne(mappedBy = "patient")
    private Appointment appointment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Clinic clinic;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Patient)) return false;
        return id != null && id.equals(((Patient) o).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
