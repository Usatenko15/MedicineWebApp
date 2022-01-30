package com.example.medicine.services;

import com.example.medicine.dto.ClinicDTO;
import com.example.medicine.model.Clinic;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.ClinicRepository;
import com.example.medicine.repository.DoctorRepository;
import com.example.medicine.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public ClinicService(ClinicRepository clinicRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.clinicRepository = clinicRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }


    public ClinicDTO createClinic(Clinic clinic) {
        return clinicRepository.save(clinic).toDTO(true);
    }

    public ClinicDTO getClinic(Long id){
        return clinicRepository.findById(id).get().toDTO(true);
    }

    public List<ClinicDTO> getAllClinic() {
        return clinicRepository.findAll().stream().map(clinic-> clinic.toDTO(true)).collect(Collectors.toList());
    }

    public ClinicDTO employeeDoctorToClinic(Long clinicId, Long doctorId) {
        Clinic clinic = clinicRepository.findById(clinicId).get();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        clinic.addDoctor(doctor);
        return clinicRepository.save(clinic).toDTO(true);
    }

    public ClinicDTO addPatientToClinic(Long clinicId, Long patientId) {
        Clinic clinic = clinicRepository.findById(clinicId).get();
        Patient patient = patientRepository.findById(patientId).get();
        clinic.addPatient(patient);
        patientRepository.save(patient);
        return clinic.toDTO(true);
    }

}
