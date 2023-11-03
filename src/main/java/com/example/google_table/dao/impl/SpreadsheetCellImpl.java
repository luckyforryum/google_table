package com.example.google_table.dao.impl;

import com.example.google_table.dao.SpreadsheetCellDao;
import com.example.google_table.entity.SpreadsheetCell;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import static com.example.google_table.util.CalculatorUtils.evaluateExpression;

@Repository
@RequiredArgsConstructor
public class SpreadsheetCellImpl implements SpreadsheetCellDao {

    private final EntityManager entityManager;
    @Override
    public void save(Map<String, String> request) {
        String cellName = request.get("cellName");
        String cellValue = request.get("cellValue");
        String originalFormula = request.get("formula");

        String column = null;
        String row = null;
        if (cellName != null) {
            String[] parts = parseCellName(cellName);
            if (parts.length == 2) {
                column = parts[0];
                row = parts[1];
            }
        }
        if (column != null && row != null) {
            updateOrInsertCell(column, row, cellValue,originalFormula);
        }
    }

    private String[] parseCellName(String cellName) {
        return cellName.split("(?<=\\D)(?=\\d)");
    }

    private void updateOrInsertCell(String column, String row, String cellValue, String originalFormula) {
        String jpql = "UPDATE SpreadsheetCell SET value = :value , formula =: formula WHERE column = :column_name AND row = :row ";
        int updatedEntities = entityManager.createQuery(jpql)
                .setParameter("value", cellValue)
                .setParameter("column_name", column)
                .setParameter("row", row)
                .setParameter("formula",originalFormula)
                .executeUpdate();

        if (updatedEntities == 0) {
            SpreadsheetCell newCell = new SpreadsheetCell();
            newCell.setColumn(column);
            newCell.setRow(row);
            newCell.setValue(cellValue);
            newCell.setFormula(originalFormula);
            entityManager.persist(newCell);
        }
    }



    @Override
    public Map<String,Double> calculate(Map<String, String> request) {
        evaluateExpression(request);
        save(request);
        Double a = Double.valueOf(request.get("cellValue"));
        Map<String, Double> response = new HashMap<>();
        response.put("result",a);
        return response;
    }


}
