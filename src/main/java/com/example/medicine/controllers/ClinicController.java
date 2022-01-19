package com.example.medicine.controllers;

import com.example.medicine.model.Clinic;
import com.example.medicine.services.ClinicService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clinics")
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Clinic createClinic(@RequestBody Clinic clinic){ return clinicService.createClinic(clinic);}

    @GetMapping
    public List<Clinic> getAllClinics(){return clinicService.getAllClinic();}

    @GetMapping("/{clinicId}")
    public Clinic getClinic(@PathVariable Long clinicId){return clinicService.getClinic(clinicId);}

    @PutMapping("/{clinicId}/doctors/{doctorId}")
    public Clinic employeeDoctorToClinic(
            @PathVariable Long clinicId,
            @PathVariable Long doctorId
    ) {
        return clinicService.employeDoctorToClinic(clinicId, doctorId);
    }

    @PutMapping("/{clinicId}/patients/{patientId}")
    public Clinic addPatientToClinic(
            @PathVariable Long clinicId,
            @PathVariable Long patientId
    ) {
        return clinicService.addPatientToClinic(clinicId, patientId);
    }

}
