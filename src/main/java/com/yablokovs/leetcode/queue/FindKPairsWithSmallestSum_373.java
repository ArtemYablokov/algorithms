package com.yablokovs.leetcode.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum_373 {

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( (p1, p2) -> Integer.compare( p1.a + p1.b, p2.a + p2.b ) );

        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new Pair(nums1[i], nums2[0], 0));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Pair cur = pq.poll();
            // if (cur == null) break;
            result.add(List.of(cur.a, cur.b));

            if (cur.idx < nums2.length - 1) {
                pq.offer(new Pair( cur.a, nums2[cur.idx + 1], cur.idx + 1 ) );
            }
        }

        return result;
    }

    class Pair {
        public int a;
        int b;
        int idx;

        public Pair(int a, int b, int idx) {
            this.a = a;
            this.b = b;
            this.idx = idx;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        for (int i = 0; i < nums1.length && i < k; i++)
            que.offer(new int[]{nums1[i], nums2[0], 0});

        while (k-- > 0 && !que.isEmpty()) {
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1)
                continue;
            que.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairsHARD(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k);
        int arr[] = new int[nums1.length];
        long g = (long)nums1.length * (long)nums2.length;
        int minIter = k;
        if( g < k) minIter = (int)g;
        for(int j=0; j<minIter; j++){
            int i = 0;
            List<Integer> tmp = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            int ind = 0;
            while(i < nums1.length && (i == 0 || arr[i-1] != 0)){
                if(arr[i] >= nums2.length) {
                    i++;
                    continue;
                }
                if( min > nums1[i] + nums2[arr[i]]) {
                    min = nums1[i] + nums2[arr[i]];
                    ind = i;
                }
                i++;
            }
            arr[ind]++;
            tmp.add(nums1[ind]);
            tmp.add(nums2[arr[ind] - 1] );
            ans.add(tmp);
        }
        return ans;
    }
}
