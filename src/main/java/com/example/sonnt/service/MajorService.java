package com.example.sonnt.service;

import com.example.sonnt.entity.Major;
import com.example.sonnt.repository.MajorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    private final MajorRepository majorRepository;

    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public List<Major> findAll() {
        return majorRepository.findAll();
    }
}
