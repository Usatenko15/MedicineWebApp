package com.example.medicine.services;

import com.example.medicine.dto.DoctorDTO;
import com.example.medicine.model.District;
import com.example.medicine.model.Doctor;
import com.example.medicine.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorDTO createDoctor(Doctor doctor){ return doctorRepository.save(doctor).toDTO(true);}
    public List<DoctorDTO> getAll() {return doctorRepository.findAll().stream().map(doctor -> doctor.toDTO(true)).collect(Collectors.toList());}
}
