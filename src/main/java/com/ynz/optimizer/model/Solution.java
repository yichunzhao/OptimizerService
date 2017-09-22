/*
 * 
# solution
{
    "task": # ASCII string
    "problem": # problem as above
    "solution": {
        "items" : # array of integers (indices to weights and values)
        "timeUsed": # non-negative integer, timeUsed elapsed between the task was started and completed
    }
}

 */
package com.ynz.optimizer.model;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author YNZ
 */
@Entity
@Data
public class Solution implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task; 
    
    private int[] items;
    private int timeUsed;
    

    public Solution() {
    }

    public Solution(String task, int[] items, int time) {
        this.task = task;
        this.items = items;
        this.timeUsed = time;
    }
}
