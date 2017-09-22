/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.repository;

import com.ynz.optimizer.model.Status;
import com.ynz.optimizer.model.Task;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author YNZ
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByStatus(Status status);

}
