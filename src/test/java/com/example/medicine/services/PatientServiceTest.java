package com.example.medicine.services;

import com.example.medicine.dto.PatientDTO;
import com.example.medicine.model.Patient;
import com.example.medicine.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService patientService;

    @Test
    void shouldCreatePatientSuccessFully() {
        final Patient patient = new Patient();
        patient.setId(1l);
        patient.setName("Vlad");
        patient.setDateBirth("sfd");
        given(patientRepository.save(patient)).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        PatientDTO savedPatient = patientService.createPatient(patient);
        assertThat(savedPatient).isNotNull();

        verify(patientRepository).save(any(Patient.class));

    }

    @Test
    void getPatientById() {
        final Long id = 1l;
        final Patient patient = new Patient();
        patient.setId(1l);
        patient.setName("Vlad");
        patient.setDateBirth("sfd");

        given(patientRepository.findById(id)).willReturn(Optional.of(patient));

        final PatientDTO patientDTO = patientRepository.findById(id).get().toDTO(false);
        assertThat(patientDTO).isNotNull();
    }
}