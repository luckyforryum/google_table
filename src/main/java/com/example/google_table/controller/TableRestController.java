package com.example.google_table.controller;

import com.example.google_table.service.SpreadsheetCellService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;



@RestController
@RequiredArgsConstructor
public class TableRestController {

    private final SpreadsheetCellService spreadsheetCellService;



    @PostMapping("/processFormula")
    public Map<String, Double> processFormula(@RequestBody Map<String, String> requestData) {
        return spreadsheetCellService.calculate(requestData);
    }


    @PostMapping("/saveCellValue")
    public void saveCellValue(@RequestBody Map<String, String> request) {
       spreadsheetCellService.save(request);

    }

}
