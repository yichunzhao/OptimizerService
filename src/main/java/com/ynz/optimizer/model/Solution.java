/*
 * 
# solution
{
    "taskToSolve": # ASCII string
    "problem": # problem as above
    "solution": {
        "items" : # array of integers (indices to weights and values)
        "time": # non-negative integer, time elapsed between the taskToSolve was started and completed
    }
}

 */
package com.ynz.optimizer.model;

import java.io.Serializable;
import javax.persistence.Column;
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
    @Column(name = "SOLUTION_ID_PK")
    private long id;

    private String task;

    private int[] items;

    private int time;

    @Embedded
    private Problem problem;

    public Solution() {
    }
}
