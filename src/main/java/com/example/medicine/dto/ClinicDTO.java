package com.example.medicine.dto;

import com.example.medicine.model.Clinic;
import com.example.medicine.model.Doctor;
import com.example.medicine.model.Patient;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ClinicDTO {
    private Long id;
    private String name;
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<PatientDTO> patientsDTO;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<DoctorDTO> doctorsDTO;

//    public static ClinicDTO toDTO(Clinic clinic){
//        ClinicDTO clinicDTO = new ClinicDTO();
//        clinicDTO.setId(clinic.getId());
//        clinicDTO.setName(clinic.getName());
//        clinicDTO.setAddress(clinic.getAddress());
//        clinicDTO.setDoctorsDTO(clinic.getDoctors().stream().map(doctor -> DoctorDTO.toDTO(doctor)).collect(Collectors.toSet()));
////        clinicDTO.setPatientsDTO(cl);
//        return clinicDTO;
//    }
}
