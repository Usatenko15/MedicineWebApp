package com.example.medicine.services;

import com.example.medicine.dto.AppointmentDTO;
import com.example.medicine.model.Appointment;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.AppointmentRepository;
import com.example.medicine.repository.DoctorRepository;
import com.example.medicine.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public AppointmentDTO createAppointment(@PathVariable Long doctorID, @PathVariable Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorID).orElseThrow(NoSuchElementException::new);
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoSuchElementException::new);
        if (doctor.getClinics().contains(patient.getClinic())) {
            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointmentRepository.save(appointment).toDTO();
            return appointment.toDTO();
        }
        throw new NoSuchElementException();
    }

    public List<AppointmentDTO> getAll() {
        return appointmentRepository.findAll().
                stream().map(appointment -> appointment.toDTO()).collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow().toDTO();
    }

    public List<AppointmentDTO> getAppointmentsByDoctor(Long doctorID) {
        return doctorRepository.findById(doctorID).orElseThrow().getAppointment().
                stream().map(appointment -> appointment.toDTO()).collect(Collectors.toList());
    }


}
