package com.example.medicine.services;

import com.example.medicine.model.Clinic;
import com.example.medicine.repository.ClinicRepository;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public Clinic CreateClinic(Clinic clinic) {return clinicRepository.save(clinic);}

}
