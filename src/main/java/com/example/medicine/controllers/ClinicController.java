package com.example.medicine.controllers;

import com.example.medicine.model.Clinic;
import com.example.medicine.services.ClinicService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clinics")
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping
    public Clinic createClinic(@RequestBody Clinic clinic){ return clinicService.CreateClinic(clinic);}

}
