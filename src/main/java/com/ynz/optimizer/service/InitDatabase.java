/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.service;

import com.ynz.optimizer.model.Problem;
import com.ynz.optimizer.model.Solution;
import com.ynz.optimizer.model.Status;
import com.ynz.optimizer.model.Task;
import com.ynz.optimizer.model.Timestamps;
import com.ynz.optimizer.repository.SolutionRepository;
import com.ynz.optimizer.repository.TaskRepository;
import java.sql.Timestamp;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author YNZ
 */
@Component
public class InitDatabase implements CommandLineRunner {
    
    @Autowired
    private SolutionRepository solutionRepository;
    
    @Autowired
    private TaskRepository taskRepository;
    
    int[] weights = {50, 10, 20, 40, 30};
    int[] values = {300, 60, 90, 100, 240};
    int capacity = 60;
    
    Problem problem = new Problem(capacity, weights, values);
    
    Task task = new Task();
    Timestamps stamps = new Timestamps();
    
    private Solution solution = new Solution();
    
    @Override
    public void run(String... strings) throws Exception {
        solution.setTask(UUID.randomUUID().toString());
        solution.setProblem(problem);
        
        solutionRepository.save(solution);
        
        stamps.setStarted(new Timestamp(System.currentTimeMillis()));
        stamps.setSubmitted(new Timestamp(System.currentTimeMillis()));
        stamps.setCompleted(new Timestamp(System.currentTimeMillis()));
        task.setStatus(Status.STARTED);
        task.setTimestamps(stamps);
        task.setTask(UUID.randomUUID().toString());
        
        taskRepository.save(task);
       
    }
    
}
