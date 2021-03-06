package com.example.medicine.dto;

import com.example.medicine.model.Clinic;
import com.example.medicine.model.Patient;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Transient;

@Data
public class PatientDTO {
    private long id;
    private String name;
    private String dateBirth;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ClinicDTO clinic;
}
