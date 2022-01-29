package com.example.medicine.controllers;

import com.example.medicine.dto.DoctorDTO;
import com.example.medicine.model.Doctor;
import com.example.medicine.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public DoctorDTO createDoctor(@RequestBody Doctor doctor){ return doctorService.createDoctor(doctor);}

    @GetMapping
    public List<DoctorDTO> getAllDoctors(){ return  doctorService.getAll();}

}
