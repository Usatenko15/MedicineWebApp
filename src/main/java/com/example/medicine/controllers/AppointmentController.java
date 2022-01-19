package com.example.medicine.controllers;

import com.example.medicine.model.Appointment;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.AppointmentRepository;
import com.example.medicine.repository.DoctorRepository;
import com.example.medicine.repository.PatientRepository;
import com.example.medicine.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    private final AppointmentService appointmentService;

    public AppointmentController(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository, AppointmentService appointmentService) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentService = appointmentService;
    }

    @GetMapping()
    public List<Appointment> getAll() {
        return appointmentService.getAll();
    }

    @PutMapping("/{doctorID}/{patientId}")
    public Appointment sadsadsad(@PathVariable Long doctorID, @PathVariable Long patientId){
        Doctor doctor = doctorRepository.findById(doctorID).get();
        Patient patient = patientRepository.findById(patientId).get();
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }

}
