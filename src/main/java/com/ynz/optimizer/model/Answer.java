/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.model;

import lombok.Data;

/**
 *
 * @author YNZ
 */

@Data
public class Answer {
    
    private Task task;
    private Problem problem;
    private Solution solution; 

    public Answer() {
    }

    public Answer(Task task, Problem problem, Solution solution) {
        this.task = task;
        this.problem = problem;
        this.solution = solution;
    }
    
}
