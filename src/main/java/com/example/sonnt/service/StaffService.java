package com.example.sonnt.service;

import com.example.sonnt.entity.Staff;
import com.example.sonnt.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public Staff findById(String id) {
        return staffRepository.findById(id).orElse(null);
    }

    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

}
