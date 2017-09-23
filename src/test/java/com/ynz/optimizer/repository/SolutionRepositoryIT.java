/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.repository;

import com.ynz.optimizer.model.Problem;
import com.ynz.optimizer.model.Solution;
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
//@Transactional
public class SolutionRepositoryIT {

    @Autowired
    private SolutionRepository repository;

    private Solution solution;
    private Problem problem;

    private int knapsackWeight = 60;
    private int[] weights = {50, 10, 20, 40, 30};
    private int[] values = {300, 60, 90, 100, 240};

    public SolutionRepositoryIT() {
        problem = new Problem();
        solution = new Solution();

        problem.setCapacity(knapsackWeight);
        problem.setPrices(values);
        problem.setWeights(weights);
        
        solution.setProblem(problem);
    }

    @Test
    public void testSaveSolution() {
        Solution added = repository.save(solution);
        Assert.assertEquals(added.getProblem(), problem);
    }

}
