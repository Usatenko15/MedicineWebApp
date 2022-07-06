package com.example.medicine.controllers;

import com.example.medicine.dto.AppointmentDTO;
import com.example.medicine.model.Appointment;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.AppointmentRepository;
import com.example.medicine.repository.DoctorRepository;
import com.example.medicine.repository.PatientRepository;
import com.example.medicine.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository, AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping()
    public ResponseEntity getAll() {
        return ResponseEntity.ok(appointmentService.getAll());
    }

    @GetMapping("/{appointmentID}")
    public ResponseEntity getAppointmentById(@PathVariable Long appointmentID) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentID));
    }

    @GetMapping("/doctor/{doctorID}")
    public ResponseEntity getAppointmentsByDoctorId(@PathVariable Long doctorID) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorID));
    }

    @PutMapping("/{doctorID}/{patientId}")
    public ResponseEntity createAppointment(@PathVariable Long doctorID, @PathVariable Long patientId){
        try {
            appointmentService.createAppointment(doctorID,patientId);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            ResponseEntity.ok(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        }

    }

}
