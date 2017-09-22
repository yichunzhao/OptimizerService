/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.model;

import java.sql.Timestamp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YNZ
 */
public class TimestampsTest {
    
    private Timestamps t;
    
    public TimestampsTest() {
        t = new Timestamps();
        t.setCompleted(new Timestamp(System.currentTimeMillis()));
        t.setStarted(new Timestamp(System.currentTimeMillis()));
        t.setSubmitted(new Timestamp(System.currentTimeMillis()));
    }
    
    @Test
    public void testGetSubmitted() {
        assertNotNull(t.getSubmitted());
        
    }
    
    @Test
    public void testGetStarted() {
        assertNotNull(t.getStarted());
    }
    
    @Test
    public void testGetCompleted() {
        assertNotNull(t.getCompleted());
    }
    
}
