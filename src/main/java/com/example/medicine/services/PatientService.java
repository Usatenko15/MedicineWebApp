package com.example.medicine.services;

import com.example.medicine.model.Patient;
import com.example.medicine.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public List<Patient> getAll(){ return patientRepository.findAll();}
}
