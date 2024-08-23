package com.example.sonnt.service;

import com.example.sonnt.entity.Facility;
import com.example.sonnt.repository.FacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
