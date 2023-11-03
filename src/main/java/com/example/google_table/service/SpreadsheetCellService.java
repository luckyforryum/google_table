package com.example.google_table.service;

import java.util.Map;

public interface SpreadsheetCellService {
    void save(Map<String, String> request);
    Map<String,Double> calculate(Map<String, String> request);

}
