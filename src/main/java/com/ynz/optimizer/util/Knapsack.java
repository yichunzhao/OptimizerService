/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynz.optimizer.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YNZ
 */
public class Knapsack {

    public List<Integer> solve(int[] wt, int[] val, int W, int N) {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                int m1 = m[i - 1][j];
                int m2 = NEGATIVE_INFINITY;
                if (j >= wt[i]) {
                    m2 = m[i - 1][j - wt[i]] + val[i];
                }
                /**
                 * select max of m1, m2 *
                 */
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }
        /**
         * make list of what all items to finally select *
         */
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w] != 0) {
                selected[n] = 1;
                w = w - wt[n];
            } else {
                selected[n] = 0;
            }
        }
        /**
         * Print finally selected items *
         */
        //System.out.println("\nItems selected : ");

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            if (selected[i] == 1) {
                //System.out.print(i + " ");
                result.add(i);

            }
        }
        //System.out.println();

        return result;
    }

    public List<Integer> calculate(int[] weights, int[] values, int knapsackWeight) {
        if (weights.length != values.length) {
            throw new IllegalArgumentException("weights and values should have the same length");
        }

        int n = weights.length;
//        int[] result = null;

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1, j = 0; i < w.length; i++, j++) {
            w[i] = weights[j];
            v[i] = values[j];
        }

        Knapsack knapsack = new Knapsack();
        List<Integer> selected = knapsack.solve(w, v, knapsackWeight, n);

//        System.out.println("w : " + Arrays.toString(w));
//        System.out.println("v : " + Arrays.toString(v));
        return selected;
    }

    public static void main(String[] args) {

        int knapsackWeight = 60;

        Knapsack knapsack = new Knapsack();

        int[] weights_ = {50, 10, 20, 40, 30};
        int[] values_ = {300, 60, 90, 100, 240};

        List<Integer> r = knapsack.calculate(weights_, values_, knapsackWeight);
        r.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();

    }

}
