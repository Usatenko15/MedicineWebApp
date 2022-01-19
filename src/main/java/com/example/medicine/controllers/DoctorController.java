package com.example.medicine.controllers;

import com.example.medicine.model.District;
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
    public Doctor createDoctor(@RequestBody Doctor doctor){ return doctorService.CreateDoctor(doctor);}

    @GetMapping
    public List<Doctor> getAllDoctors(){ return  doctorService.getAll();}

}
