package com.example.medicine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ClinicGetDTO {
    private Long id;
    private String name;
    private String address;
}
