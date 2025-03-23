package com.yablokovs.LC_v3.dp;

import java.util.ArrayList;
import java.util.List;

public class DeleteAndEarn_740 {
        List<Integer> list = new ArrayList<>();
        int[] count;
        public int deleteAndEarn(int[] nums) {
            int max = (int) 1e4 + 1;
            count = new int[max];
            for (int n : nums)
                count[n]++;

            for (int i = 0; i < max; i++) {
                if (count[i] != 0) list.add(i);
            }
            return dfs(0);
        }

        int dfs(int ix) {
            if (ix == list.size()) return 0;
            int num = list.get(ix);

            int cur = count[num] * num;
            int next = dfs(ix + 1);
            if (ix < list.size() - 1 && num + 1 == list.get(ix + 1)) {
                int skip = cur + dfs(ix + 2);
                return Math.max(skip, next);
            } else {
                return cur + next;
            }
        }

}
