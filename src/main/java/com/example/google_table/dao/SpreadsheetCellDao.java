package com.example.google_table.dao;

import java.util.Map;

public interface SpreadsheetCellDao {

    void save(Map<String, String> request);
    Map<String,Double> calculate(Map<String, String> request);
}
