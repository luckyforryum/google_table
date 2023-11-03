package com.example.google_table.service.impl;

import com.example.google_table.dao.SpreadsheetCellDao;
import com.example.google_table.service.SpreadsheetCellService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SpreadsheetCellServiceImpl implements SpreadsheetCellService {

    private final SpreadsheetCellDao spreadsheetCellDao;

    @Transactional
    @Override
    public void save(Map<String, String> request) {
        spreadsheetCellDao.save(request);
    }

    @Transactional
    @Override
    public Map<String, Double> calculate(Map<String, String> request) {
        return spreadsheetCellDao.calculate(request);
    }
}
