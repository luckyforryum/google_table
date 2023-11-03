package com.example.google_table.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TableController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

}

