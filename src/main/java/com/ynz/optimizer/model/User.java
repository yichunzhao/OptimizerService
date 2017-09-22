/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.model;

import java.io.Serializable;
import javax.persistence.Column;
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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id; 
    
    @Column(name = "USER_NAME")
    private String userName; 
    
    @Column(name = "PASS_WORD")
    private String passWord; 
    
    @Column(name = "USER_ROLE")
    private String userRole; 
    
    public User(){
        
    }

    public User(long id, String userName, String passWord, String userRole) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.userRole = userRole;
    }

    
}
