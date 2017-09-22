/*
 * 
# solution
{
    "task": # ASCII string
    "problem": # problem as above
    "solution": {
        "items" : # array of integers (indices to weights and values)
        "time": # non-negative integer, time elapsed between the task was started and completed
    }
}

 */
package com.ynz.optimizer.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author YNZ
 */

@Data
public class Solution implements Serializable {
    
    private int[] items;
    
    private int time; 

    public Solution() {
    }

    public Solution(int[] items, int time) {
        this.items = items;
        this.time = time;
    }
}
