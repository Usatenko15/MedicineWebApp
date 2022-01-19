package com.example.medicine.controllers;

import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.example.medicine.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){ return patientService.createPatient(patient);}

    @GetMapping
    public List<Patient> getAllPatients(){ return  patientService.getAll();}
}
