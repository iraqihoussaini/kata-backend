package com.kata.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kata.quiz.service.DataService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/")
@CrossOrigin

public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "convertInputToOutput", method = RequestMethod.GET)
    public ResponseEntity<String> convertInputToOutput(@PathParam("input") Integer input) {
        return ResponseEntity.ok(dataService.convertInputToOutput(input));
    }
}
