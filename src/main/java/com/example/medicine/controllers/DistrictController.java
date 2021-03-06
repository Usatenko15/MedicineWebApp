package com.example.medicine.controllers;

import com.example.medicine.dto.DistrictDTO;
import com.example.medicine.model.District;
import com.example.medicine.services.DistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/district")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping
    public DistrictDTO createDistrict(@RequestBody District district) {
        return districtService.createDistrict(district);
    }

    @GetMapping
    public List<DistrictDTO> getAllDistrict(){ return  districtService.getAll();}

    @PutMapping("/{districtId}/clinic/{clinicId}")
    public DistrictDTO addClinicToDistrict(
            @PathVariable Long districtId,
            @PathVariable Long clinicId
    ) {
        return districtService.addClinicToDistrict(districtId,clinicId);
    }

}
