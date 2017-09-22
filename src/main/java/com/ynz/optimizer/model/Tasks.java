/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author YNZ
 */

@Data
public class Tasks {
    
    private List<Task> submitted;
    private List<Task> started;
    private List<Task> completed;
    
    public Tasks(){
        submitted = new ArrayList<>();
        started = new ArrayList<>();
        completed = new ArrayList<>();
    }

    public Tasks(List<Task> submitted, List<Task> started, List<Task> completed) {
        this.submitted = submitted;
        this.started = started;
        this.completed = completed;
    }
    
    
    
}
