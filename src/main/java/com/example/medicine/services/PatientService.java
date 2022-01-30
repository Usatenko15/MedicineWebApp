package com.example.medicine.services;

import com.example.medicine.dto.ClinicDTO;
import com.example.medicine.dto.PatientDTO;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDTO createPatient(Patient patient) {
        return patientRepository.save(patient).toDTO(false);
    }
    public PatientDTO getPatient(Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return patient.toDTO(true);
    }
    public List<PatientDTO> getAll(){ return patientRepository.findAll().stream().map(patient ->patient.toDTO(true)).collect(Collectors.toList()); }
}

