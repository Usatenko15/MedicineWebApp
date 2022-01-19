package com.example.medicine.services;

import com.example.medicine.model.Clinic;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.ClinicRepository;
import com.example.medicine.repository.DoctorRepository;
import com.example.medicine.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Clinic createClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public Clinic getClinic(Long id){
        return clinicRepository.findById(id).get();
    }

    public List<Clinic> getAllClinic() {
        return clinicRepository.findAll();
    }

    public Clinic employeDoctorToClinic(Long clinicId, Long doctorId) {
        Clinic clinic = clinicRepository.findById(clinicId).get();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        clinic.addDoctor(doctor);
        return clinicRepository.save(clinic);
    }

    public Clinic addPatientToClinic(Long clinicId, Long patientId) {
        Clinic clinic = clinicRepository.findById(clinicId).get();
        Patient patient = patientRepository.findById(patientId).get();
        patient.setClinic(clinic);
        patientRepository.save(patient);
//        clinic.addPatient(patient);
        return clinicRepository.save(clinic);
    }

}
