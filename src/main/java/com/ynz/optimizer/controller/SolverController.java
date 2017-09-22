/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YNZ
 */
@RestController
public class SolverController {

    @RequestMapping(value = "/knapsack/tasks", method = RequestMethod.POST)
    public ResponseEntity create(
            @RequestParam(value = "w") int[] weight,
            @RequestParam(value = "v") int[] value,
            @RequestParam(value = "c") int capacity) {

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/knapsack/admin/shutdown", method = RequestMethod.POST)
    public ResponseEntity shutdown() {

        return new ResponseEntity("Shut down ", HttpStatus.OK);
    }

    @RequestMapping(value = "/knapsack/admin/tasks", method = RequestMethod.GET)
    public ResponseEntity getSolution(
            @RequestParam(value = "id") Long id) {
        
        
        return new ResponseEntity("task", HttpStatus.OK);
    }

}
