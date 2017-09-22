/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.repository;

import com.ynz.optimizer.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author YNZ
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class UserRepositoryIT {

    @Autowired
    private UserRepository repository;

    private Client user;

    public UserRepositoryIT() {
        user = new Client("user", "user", "user"); //"user","user","user"
    }

    @Test
    public void testSave() {
        Client added = repository.save(user);
        Client found = repository.findOne(added.getId());
        Assert.assertEquals(user.getUserRole(), found.getUserRole());
    }
    
    @Test
    public void testFindByUserName(){
        repository.save(user);
        Client found = repository.findByUserName(user.getUserName());
        Assert.assertEquals(user, found);
    }

}
