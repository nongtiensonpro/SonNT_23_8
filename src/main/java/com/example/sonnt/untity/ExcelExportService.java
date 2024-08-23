package com.example.sonnt.untity;

import com.example.sonnt.entity.Staff;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExcelExportService {

    public ByteArrayOutputStream exportStaffListToExcel(List<Staff> staffList) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Staff List");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("STT");
        headerRow.createCell(1).setCellValue("Mã nhân viên");
        headerRow.createCell(2).setCellValue("Tên nhân viên");
        headerRow.createCell(3).setCellValue("Email FPT");
        headerRow.createCell(4).setCellValue("Email FE");
        headerRow.createCell(5).setCellValue("Trạng thái");

        int rowNum = 1;
        for (Staff staff : staffList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum - 1);
            row.createCell(1).setCellValue(staff.getId());
            row.createCell(2).setCellValue(staff.getName());
            row.createCell(3).setCellValue(staff.getAccountFpt());
            row.createCell(4).setCellValue(staff.getAccountFe());
            row.createCell(5).setCellValue(staff.getStatus() == 1 ? "Hoạt động" : "Không hoạt động");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream;
    }
}
