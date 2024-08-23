package com.example.sonnt.repository;

import com.example.sonnt.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, String> {
}