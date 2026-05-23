package com.homeacc.controller;

import com.homeacc.repository.Transactions;
import com.homeacc.repository.User;
import com.homeacc.service.AuthService;
import com.homeacc.service.TransactionsService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(path = "/auth/report/")
public class ReportController {

    @Autowired
    private AuthService authService;

    @Autowired
    TransactionsService transactionsService;

    @GetMapping
    public String index(HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser != null){
            model.addAttribute("user",currentUser);
            return "report";
        } else {
            return "redirect:/";
        }

    }

    @PostMapping("/export")
    public void exportReport(HttpServletResponse response, HttpSession session) throws IOException {
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){
            response.sendRedirect("/");
            return;
        }
        List<Transactions> reportExport = transactionsService.getAllTransactions(currentUser.getLogin());
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Report");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Дата");
        headerRow.createCell(1).setCellValue("Счет");
        headerRow.createCell(2).setCellValue("Категория");
        headerRow.createCell(3).setCellValue("Подкатегория");
        headerRow.createCell(4).setCellValue("Сумма");
        headerRow.createCell(5).setCellValue("Комментарий");

        int rowNum = 1;
        for (Transactions export : reportExport) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(export.getData());
            row.createCell(1).setCellValue(export.getScore());
            row.createCell(2).setCellValue(export.getCategories());
            row.createCell(3).setCellValue(export.getSubCategories());
            row.createCell(4).setCellValue(export.getSumma().doubleValue());
            row.createCell(5).setCellValue(export.getComments());
        }

        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=myfile.xlsx");
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
