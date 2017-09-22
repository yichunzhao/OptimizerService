/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.repository;

import com.ynz.optimizer.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author YNZ
 */
public interface UserRepository extends CrudRepository<Client, Long> {

    Client findByUserName(String userName);

}
