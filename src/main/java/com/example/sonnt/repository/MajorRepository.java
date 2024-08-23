package com.example.sonnt.repository;

import com.example.sonnt.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, String> {
}