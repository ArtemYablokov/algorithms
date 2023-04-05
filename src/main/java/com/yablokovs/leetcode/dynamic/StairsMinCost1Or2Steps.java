package com.yablokovs.leetcode.dynamic;

/*
* https://leetcode.com/problems/min-cost-climbing-stairs/
* */


import java.util.HashMap;
import java.util.Map;

public class StairsMinCost1Or2Steps {

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{1,200,1,200,1,1,1,1,20,1}));

    }

    private static int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];

        for(int i = 2; i < cost.length; i++) {
            int temp = second;
            second = cost[i] + Math.min(first, second);
            first = temp;
        }
        return Math.min(first, second);
    }

    public int WTFmapSolution(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        return minCostClimbingStairs(map, cost, cost.length, 0);
    }

    public int minCostClimbingStairs(Map<Integer, Integer> map, int[] cost, int num, int result){
        if(num == 0 || num == 1){ return result; }
        if(map.containsKey(num)){ return map.get(num); }
        int result1 = minCostClimbingStairs(map, cost, num-1, cost[num-1]);
        int result2 = minCostClimbingStairs(map, cost, num-2, cost[num-2]);

        result = result + Math.min( result1, result2 );
        map.put(num, result);
        return result;
    }
}
