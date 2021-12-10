package com.example.medicine.services;

import com.example.medicine.model.Appointment;
import com.example.medicine.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }


}
