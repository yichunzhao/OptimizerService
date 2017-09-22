/*
 *     "timestamps": {
 *        "submitted": # unix/epoch time
 *      "submitted": # unix/epoch time
 *       "started": # unix/epoch time or null if not started
 *       "completed": # unix/epoch time or null if not completed
 *   }
 *
 */
package com.ynz.optimizer.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author YNZ
 */


@Embeddable
@Data
public class Timestamps implements Serializable {
    private Timestamp submitted;
    private Timestamp started;
    private Timestamp completed; 

    public Timestamps() {
    }

    public Timestamps(Timestamp submitted, Timestamp started, Timestamp completed) {
        this.submitted = submitted;
        this.started = started;
        this.completed = completed;
    }
    
}
