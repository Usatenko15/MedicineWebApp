package com.example.medicine.dto;

import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
public class AppointmentDTO {
    private Long id;
    private DoctorDTO doctor;
    private PatientDTO patient;
}
