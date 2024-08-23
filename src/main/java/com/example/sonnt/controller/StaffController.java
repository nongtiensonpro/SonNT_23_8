package com.example.sonnt.controller;

import com.example.sonnt.dto.JobChange;
import com.example.sonnt.entity.Staff;
import com.example.sonnt.service.DepartmentService;
import com.example.sonnt.service.FacilityService;
import com.example.sonnt.service.MajorService;
import com.example.sonnt.service.StaffService;
import com.example.sonnt.untity.ExcelExportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@RequestMapping("/head-office")
public class StaffController {

    private final StaffService staffService;
    private final DepartmentService departmentService;
    private final FacilityService facilityService;
    private final MajorService majorService;
    private final ExcelExportService excelExportService;


    public StaffController(StaffService staffService, DepartmentService departmentService, FacilityService facilityService, MajorService majorService, ExcelExportService excelExportService) {
        this.staffService = staffService;
        this.departmentService = departmentService;
        this.facilityService = facilityService;
        this.majorService = majorService;
        this.excelExportService = excelExportService;
    }


    @GetMapping("/staffs")
    public String getStaffs(Model model) {
        model.addAttribute("staffEdit", new Staff());
        model.addAttribute("staffsNew", new Staff());
        model.addAttribute("staffsok", staffService.findAll());
        return "head-office/staffs";
    }

    @PostMapping("/staffs/add")
    public String addStaff(Staff staff) {
        staffService.save(staff);
        return "redirect:/head-office/staffs";
    }


    @PostMapping("/staffs/edit")
    public String editStaff(@ModelAttribute Staff staff) {
        staffService.save(staff);
        return "redirect:/head-office/staffs";
    }

    @GetMapping("/staffs/detail")
    public String getStaffDetail(@RequestParam("id") String id, Model model) {
        model.addAttribute("staffDetail", staffService.findById(id));
        model.addAttribute("listDepartments", departmentService.findAll());
        model.addAttribute("listFacilities", facilityService.findAll());
        model.addAttribute("listMajors", majorService.findAll());
        model.addAttribute("JobChangeNew", new JobChange());
        return "head-office/staff-detail";
    }


    @PostMapping("/staffs/job-change/{facility}&{department}&{major}&{staff}")
    public String changeJobChange(@ModelAttribute JobChange jobChange) {

        return "redirect:/head-office/staffs";
    }


    @GetMapping("/staffs/download-template")
    public ResponseEntity<byte[]> downloadTemplate() throws IOException {
        List<Staff> listStaff = staffService.findAll();
        ByteArrayOutputStream outputStream = excelExportService.exportStaffListToExcel(listStaff);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String fileName = "StaffList_" + LocalDateTime.now().format(formatter) + ".xlsx";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(outputStream.toByteArray());
    }

    @GetMapping("/staffs/status")
    public String changeStatusStaff(@RequestParam("id") String id) {
        Staff staff = staffService.findById(id);
        if (staff.getStatus() == 1) {
            staff.setStatus((byte) 0);
        } else {
            staff.setStatus((byte) 1);
        }
        staffService.save(staff);
        return "redirect:/head-office/staffs";
    }

}
