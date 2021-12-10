package com.example.medicine.services;

import com.example.medicine.model.Doctor;
import com.example.medicine.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor CreateDoctor(Doctor doctor){ return doctorRepository.save(doctor);}
}
