/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.repository;

import com.ynz.optimizer.model.Status;
import com.ynz.optimizer.model.Task;
import com.ynz.optimizer.model.Timestamps;
import java.sql.Timestamp;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author YNZ
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TaskRepositoryIT {

    @Autowired
    TaskRepository repository;

    
    public TaskRepositoryIT() {
    }

    @Test
    public void testSave() {
        Task task = new Task();
        task.setStatus(Status.STARTED);
        task.setTask("my task");

        Timestamps timestamps = new Timestamps();
        timestamps.setStarted(new Timestamp(System.currentTimeMillis()));
        task.setTimestamps(timestamps);

        Task added = repository.save(task);
        Task found = repository.findOne(added.getId());

        assertEquals(task.getTask(), found.getTask());
    }
    
    @Test
    public void testFindByStatus(){
        Task task1 = new Task();
        task1.setStatus(Status.STARTED);
        
        Task task2 = new Task();
        task2.setStatus(Status.COMPLETED);
        
        Task task3 = new Task();
        task3.setStatus(Status.COMPLETED);
        
        repository.save(task1);
        repository.save(task2);
        repository.save(task3);
        
        List<Task> completedTasks = repository.findByStatus(Status.COMPLETED);
        
        assertEquals(2, completedTasks.size());
    }

}
