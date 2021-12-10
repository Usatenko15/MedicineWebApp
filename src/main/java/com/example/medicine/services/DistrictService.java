package com.example.medicine.services;

import com.example.medicine.model.District;
import com.example.medicine.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District createDistrict(District district) {
        return districtRepository.save(district);
    }
    public List<District> getAll() {return districtRepository.findAll();}

}
