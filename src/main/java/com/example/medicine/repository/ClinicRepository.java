package com.example.medicine.repository;

import com.example.medicine.model.Appointment;
import com.example.medicine.model.Clinic;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
