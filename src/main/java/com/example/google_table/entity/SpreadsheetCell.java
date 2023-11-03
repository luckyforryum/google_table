package com.example.google_table.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class SpreadsheetCell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "row")
    private String row;
    @Column(name = "column_name")
    private String column;
    @Column(name = "value")
    private String value;
    @Column(nullable = true,name = "formula")
    private String formula;
}
