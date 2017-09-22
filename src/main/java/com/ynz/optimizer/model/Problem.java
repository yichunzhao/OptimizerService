/*
 *# problem
 *{
 *   "problem": {
 *        "capacity": # non-negative integer
 *        "weights": # array of non-negative integers
 *        "values": # array of non-negative integers, as many as weights
 *    }
 *}

 * 
 * 
 */
package com.ynz.optimizer.model;

import lombok.Data;

/**
 *
 * @author YNZ
 */
@Data
public class Problem {

    private int capacity;
    private int[] weights;
    private int[] values;

    public Problem() {

    }

    public Problem(int capacity, int[] weights, int[] values) {
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
    }

}
