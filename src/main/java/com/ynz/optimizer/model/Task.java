/*

# task
{
    "task": # ASCII string
    "status": # one of "submitted", "started", "completed"
    "timestamps": {
        "submitted": # unix/epoch time
        "started": # unix/epoch time or null if not started
        "completed": # unix/epoch time or null if not completed
    }
}
 
 */
package com.ynz.optimizer.model;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;

    @Enumerated
    private Status status;

    @Embedded
    private Timestamps timestamps;

    public Task() {

    }

    public Task(String task, Status status, Timestamps timestamps) {
        this.task = task;
        this.status = status;
        this.timestamps = timestamps;
    }

}
