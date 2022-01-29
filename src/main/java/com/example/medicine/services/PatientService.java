package com.example.medicine.services;

import com.example.medicine.dto.ClinicDTO;
import com.example.medicine.dto.PatientDTO;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public PatientDTO getPatient(Long id){
        PatientDTO patientDTO = PatientDTO.toDTO(patientRepository.findById(id).get());
//        patientDTO.setClinic(ClinicDTO.toDTO(patientRepository.findById(id).get().getClinic()));
        return patientDTO;
    }
    public List<PatientDTO> getAll(){ return patientRepository.findAll().stream().map(patient -> {
        PatientDTO patientDTO = PatientDTO.toDTO(patient);
        if (patient.getClinic() != null) {
//            patientDTO.setClinic(ClinicDTO.toDTO(patient.getClinic()));
        }
        return patientDTO;
    }).collect(Collectors.toUnmodifiableList());}
}
