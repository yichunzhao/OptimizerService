/*
 *# problem
 *{
 *   "problem": {
 *        "capacity": # non-negative integer
 *        "weights": # array of non-negative integers
 *        "prices": # array of non-negative integers, as many as weights
 *    }
 *}

 * 
 * 
 */
package com.ynz.optimizer.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author YNZ
 */

@Embeddable
@Data
public class Problem implements Serializable {
    
    private int capacity;
    
    private int[] weights;
        
    private int[] prices;

    public Problem() {

    }

    public Problem(int capacity, int[] weights, int[] values) {
        this.capacity = capacity;
        this.weights = weights;
        this.prices = values;
    }

}
