package com.example.medicine.model;

import com.example.medicine.dto.AppointmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Patient patient;

    public AppointmentDTO toDTO(){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(id);
        appointmentDTO.setDoctor(doctor.toDTO(false));
        appointmentDTO.setPatient(patient.toDTO(false));
        return appointmentDTO;
    }

}
