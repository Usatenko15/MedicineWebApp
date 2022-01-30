package com.example.medicine.controllers;

import com.example.medicine.dto.ClinicDTO;
import com.example.medicine.dto.PatientDTO;
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
    public PatientDTO createPatient(@RequestBody Patient patient){ return patientService.createPatient(patient);}

    @GetMapping("/{patientId}")
    public PatientDTO getPatient(@PathVariable Long patientId) throws Exception {return patientService.getPatient(patientId);}

    @GetMapping
    public List<PatientDTO> getAllPatients(){ return  patientService.getAll();}
}
