package com.example.medicine.model;

import com.example.medicine.dto.DoctorDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String degree;


    @ManyToMany(mappedBy = "doctors", fetch = FetchType.EAGER)
    private Set<Clinic> clinics = new HashSet<>();

    @OneToOne(mappedBy = "doctor")
    private Appointment appointment;

    public DoctorDTO toDTO() {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(this.getId());
        doctorDTO.setName(this.getName());
        doctorDTO.setDegree(this.getDegree());
//        doctorDTO.setClinicsDTO(this.getClinics().stream().map(clinic -> clinic.toDTO()).collect(Collectors.toSet()));
        return doctorDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Doctor)) return false;
        return id != null && id.equals(((Doctor) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
