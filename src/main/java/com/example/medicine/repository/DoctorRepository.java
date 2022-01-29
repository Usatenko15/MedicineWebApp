package com.example.medicine.repository;

import com.example.medicine.model.Clinic;
import com.example.medicine.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT d.name from Doctor d join d.clinics c where c.id = :id")
    Set<String> findDoctorByClinics(String id);

}
