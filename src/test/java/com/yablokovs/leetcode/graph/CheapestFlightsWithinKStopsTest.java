package com.yablokovs.leetcode.graph;

import org.junit.jupiter.api.Test;

class CheapestFlightsWithinKStopsTest {

    @Test
    void findCheapestPrice() {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int cheapestPrice = cheapestFlightsWithinKStops.cheapestFlightsWithinKStops(10,
                new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}},
                6, 0, 7
        ); // 14

        int cheapestPrice2 = cheapestFlightsWithinKStops.cheapestFlightsWithinKStops(4,
                new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},
                0, 3, 1
        ); // 700

        int cheapestPrice3 = cheapestFlightsWithinKStops.cheapestFlightsWithinKStops(4,
                new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}},
                0, 2, 2
        ); // 2?

        int cheapestPrice4 = cheapestFlightsWithinKStops.cheapestFlightsWithinKStops(4,
                new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}},
                0, 2, 3
        ); // 6?
        long l = System.currentTimeMillis();
        int cheapestPrice5 = cheapestFlightsWithinKStops.cheapestFlightsWithinKStops(17,
                new int[][]
                        {{0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},{10,12,35},{15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},{2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},{10,15,19},{12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},{16,12,13},{7,1,29},{7,14,100},{16,1,14},{9,6,74},{11,1,73},{2,11,60},{10,11,85},{2,5,49},{3,4,17},{4,9,77},{16,3,47},{15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},{10,4,86},{0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},{8,11,31},{6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},{11,2,74},{12,14,48},{16,11,100},{3,12,38},{12,13,77},{10,9,99},{15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},{8,9,14},{15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},{13,5,77},{10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},{13,11,64},{8,13,80},{6,12,74},{9,7,35},{0,15,48},{3,7,87},{16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},{16,14,52},{3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},{14,6,84},{13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},{7,12,64},{0,10,76},{5,9,77},{8,3,28},{11,9,28},{12,16,87},{12,6,24},{9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}}
                ,
                13, 4, 13
        ); // 47

        long l1 = System.currentTimeMillis();

        double secs = (l1 - l) / 1000d;


        int n = 0;
    }
}