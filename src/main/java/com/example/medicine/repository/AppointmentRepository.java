package com.example.medicine.repository;

import com.example.medicine.model.Appointment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Override
    @EntityGraph(attributePaths = {"doctor","patient"})
    List<Appointment> findAll();

}
