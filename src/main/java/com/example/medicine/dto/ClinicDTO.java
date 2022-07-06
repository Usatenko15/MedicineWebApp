package com.example.medicine.dto;

import com.example.medicine.model.Clinic;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ClinicDTO {
    private Long id;
    private String name;
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<PatientDTO> patientsDTO;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<DoctorDTO> doctorsDTO;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DistrictDTO districtDTO;
}
