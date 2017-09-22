/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.controller;

import com.ynz.optimizer.model.Problem;
import com.ynz.optimizer.model.Solution;
import com.ynz.optimizer.model.Status;
import com.ynz.optimizer.model.Task;
import com.ynz.optimizer.model.Timestamps;
import com.ynz.optimizer.util.Knapsack;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity create(@RequestBody Problem problem) {
        Knapsack ks = new Knapsack();

        //create a task
        Task task = new Task();
        task.setStatus(Status.SUBMITTED);
        task.setTask("my task");
        
        //time stamp
        Timestamps timestamps = new Timestamps();
        timestamps.setSubmitted(new Timestamp(System.currentTimeMillis()));
        task.setTimestamps(timestamps);

        int[] items = ks.calculate(problem); 
        
        Solution solution = new Solution();
        solution.setItems(items);
        
        return new ResponseEntity(solution, HttpStatus.ACCEPTED);
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
