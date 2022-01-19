package com.example.medicine.services;

import com.example.medicine.model.Clinic;
import com.example.medicine.model.District;
import com.example.medicine.repository.ClinicRepository;
import com.example.medicine.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;
    private final ClinicRepository clinicRepository;

    public DistrictService(DistrictRepository districtRepository, ClinicRepository clinicRepository) {
        this.districtRepository = districtRepository;
        this.clinicRepository = clinicRepository;
    }

    public District createDistrict(District district) {
        return districtRepository.save(district);
    }
    public List<District> getAll() {return districtRepository.findAll();}
    public District addClinicToDistrict(Long districtId, Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId).get();
        District district = districtRepository.findById(districtId).get();
        district.setClinic(clinic);
        return districtRepository.save(district);
    }

}
