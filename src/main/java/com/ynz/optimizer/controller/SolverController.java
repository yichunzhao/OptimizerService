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
import com.ynz.optimizer.repository.SolutionRepository;
import com.ynz.optimizer.repository.TaskRepository;
import com.ynz.optimizer.util.Knapsack;
import java.sql.Timestamp;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    final private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SolutionRepository solutionRepository;

    @RequestMapping(value = "/knapsack/tasks", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Problem problem) {

        //create a task
        Task task = new Task();
        task.setStatus(Status.SUBMITTED);
        task.setTask(UUID.randomUUID().toString());

        //time stamp
        Timestamps timestamps = new Timestamps();
        timestamps.setSubmitted(new Timestamp(System.currentTimeMillis()));
        task.setTimestamps(timestamps);

        //save the task in db
        taskRepository.save(task);

        //set a problem
        //spawn a new thread to solve the problem
        new Thread(() -> {
            timestamps.setStarted(new Timestamp(System.currentTimeMillis()));
            task.setStatus(Status.STARTED);
            //need a new thread to do calculation
            Knapsack ks = new Knapsack();
            int[] items = ks.calculate(problem);
            timestamps.setCompleted(new Timestamp(System.currentTimeMillis()));
            //now we have a sloution
            Solution solution = new Solution();
            //solution.setProblem(problem);
            solution.setItems(items);
            long timeCost = task.getTimestamps().getCompleted().getTime() - task.getTimestamps().getStarted().getTime();
            solution.setTime((int) timeCost);
            solution.setTask(task.getTask());

            task.setStatus(Status.COMPLETED);

            //keep task and solution in the database. 
            solutionRepository.save(solution);
            taskRepository.save(task);
        }
        ).start();

        return new ResponseEntity(task, HttpStatus.ACCEPTED);
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
