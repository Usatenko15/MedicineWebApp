package com.example.medicine.repository;

import com.example.medicine.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Set<Patient> findPatientByClinic_Id(Long id);
}
