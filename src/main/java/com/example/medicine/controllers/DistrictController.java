package com.example.medicine.controllers;

import com.example.medicine.model.District;
import com.example.medicine.services.DistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/districts")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping
    public District createDistrict(@RequestBody District district) {
        return districtService.createDistrict(district);
    }

    @GetMapping
    public List<District> getAllDistrict(){ return  districtService.getAll();}

}
