/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.controller;

import com.ynz.optimizer.model.Problem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 *
 * @author YNZ
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SolverControllerIT {

    public static final String PATH_CREATE = "/knapsack/tasks";
    public static final String PATH_CHECKTASK = "/knapsack/tasks/";
    public static final String PATH_GETSOLUTION = "/knapsack/solutions/";

    @Autowired
    MockMvc mvc;

    public SolverControllerIT() {
    }

    @Test
    public void testCreate() throws Exception {
        int[] weights = {50, 10, 20, 40, 30};
        int[] values = {300, 60, 90, 100, 240};
        int capacity = 60;

        Problem problem = new Problem(capacity, weights, values);

        this.mvc.perform(post(PATH_CREATE)
                .with(user("test").password("test").roles("test"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(problem)))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string(containsString("timestamps")))
                .andExpect(content().string(containsString("status")));

        //.andExpect(content().string(containsString("time")))
        //.andExpect(content().string(containsString("problem")))
        //.andExpect(content().string(containsString("[2,3,5]")));
        //.andExpect(jsonPath("$.items", is(expected)));
        //.andExpect(jsonPath("$.lastName", is("Zhao")));
    }

    @Test
    public void testCheckTask() throws Exception {
        this.mvc.perform(get(PATH_CHECKTASK + "1").with(user("test").password("test").roles("test")))
                .andExpect(status().isFound())
                .andExpect(content().string(containsString("timestamps")));
    }

    @Test
    public void testCheckTask_NotFound() throws Exception {
        this.mvc.perform(get(PATH_CHECKTASK + "2").with(user("test").password("test").roles("test")))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("not existed")));
    }

    @Test
    public void testGetSolution() throws Exception {
        this.mvc.perform(get(PATH_GETSOLUTION + "1").with(user("test").password("test").roles("test")))
                .andExpect(status().isFound());
    }

    @Test
    public void testGetSolution_NotFound() throws Exception {
        this.mvc.perform(get(PATH_GETSOLUTION + "2").with(user("test").password("test").roles("test")))
                .andExpect(status().isNotFound());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
