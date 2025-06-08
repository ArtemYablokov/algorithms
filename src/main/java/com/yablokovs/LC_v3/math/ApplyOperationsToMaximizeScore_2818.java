package com.yablokovs.LC_v3.math;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ApplyOperationsToMaximizeScore_2818 {

    public final int LIMIT = (int) 1e5;
    public final int MOD = (int) 1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        SortedSet<Integer> primes = getPrimes();

//        List<Integer> reveresedPrimes = primes.stream().sorted(Comparator.reverseOrder()).toList();
        int l = nums.size();
        int[] primeScore = new int[l];
        for (int i = 0; i < l; i++) {
            int primeScoreI = getPrimeScore(nums.get(i), primes);
            primeScore[i] = primeScoreI;
        }

        LinkedList<Integer> mono = new LinkedList<>(); // left stack - left element should be strictly less
        mono.push(-1);
        int[] left = new int[l];
        for (int i = 0; i < l; i++) {
            int cur = primeScore[i];
            while (!mono.isEmpty() && mono.peek() != -1 && primeScore[mono.peek()] < cur) {
                mono.pop();
            }
            left[i] = mono.peek();
            mono.push(i);
        }

        mono = new LinkedList<>(); // left stack - left element should be strictly less
        mono.push(l);
        int[] right = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            int cur = primeScore[i];
            while (!mono.isEmpty() && mono.peek() != l && primeScore[mono.peek()] <= cur) {
                mono.pop();
            }
            right[i] = mono.peek();
            mono.push(i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0])); // sort BY VALUES DECR
        int size = 0;
        for (int i = 0; i < l; i++) {
            int leftSize = i - left[i];
            int rightSize = right[i] - i;
            int total = rightSize * leftSize;
            pq.offer(new int[]{nums.get(i), total});
            size += total;
//            if (size >= k)
//                break;
        }
        int result = 1;
        while (k > 0) {
            int[] cur = pq.poll();
            int val = (int) cur[0];
            int number = cur[1];

                for (int i = 0; i < Math.min(number, k); i++) {
                result *= val;
                result %= MOD;
            }
            k -= number;
        }

        return result;
    }

    SortedSet<Integer> getPrimes() {
        boolean[] notPrimes = new boolean[LIMIT + 1];
        for (int i = 2; i < LIMIT / 2; i++) {

            for (int j = 2; j < LIMIT / 2; j++) {
                int val = i * j;
                if (val >= LIMIT)
                    break;
                notPrimes[val] = true;
            }
        }
        SortedSet<Integer> primes = new TreeSet<>();

        for (int i = 2; i < LIMIT; i++) {
            if (!notPrimes[i])
                primes.add(i);
        }
        return primes;
    }

    int getPrimeScore(int num, SortedSet<Integer> primes) {
//        int score = 0;
        Set<Integer> set = new HashSet<>();

        while (num > 1) {
            if (primes.contains(num)) {
                set.add(num);
                break;
            }
            for (int p : primes) {
                if (num % p == 0) {
                    set.add(p);
                    num /= p;
                    break;
                }
            }
        }

        return set.size();
    }

}
