package com.example.medicine.dto;

import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class DoctorDTO {
    private Long id;
    private String name;
    private String degree;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Set<ClinicDTO> clinicsDTO;
}
