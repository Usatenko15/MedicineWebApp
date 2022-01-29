package com.example.medicine.model;

import com.example.medicine.dto.ClinicDTO;
import com.example.medicine.dto.DoctorDTO;
import com.example.medicine.dto.PatientDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Doctor> doctors = new HashSet<>();

    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private Set<Patient> patients = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "clinic")
    private District district;

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        doctor.getClinics().add(this);
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
        patient.setClinic(this);
    }

    public ClinicDTO toDTO() {
        ClinicDTO clinicDTO = new ClinicDTO();
        clinicDTO.setId(this.getId());
        clinicDTO.setName(this.getName());
        clinicDTO.setAddress(this.getAddress());
        clinicDTO.setDoctorsDTO(this.getDoctors().stream().map(doctor -> doctor.toDTO()).collect(Collectors.toSet()));
        clinicDTO.setPatientsDTO(this.getPatients().stream().map(patient -> PatientDTO.toDTO(patient)).collect(Collectors.toSet()));
        return clinicDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Clinic)) return false;
        return id != null && id.equals(((Clinic) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
