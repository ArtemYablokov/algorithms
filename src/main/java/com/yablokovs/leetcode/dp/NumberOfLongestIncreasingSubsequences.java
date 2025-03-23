package com.yablokovs.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfLongestIncreasingSubsequences {
    public int findNumberOfLISDP(int[] nums) {
        int l = nums.length;

        int[] dp = new int[l];
        int[] count = new int[l];
        int result = 0;
        int max = 0;

        for (int i = l - 1; i > -1; i--) {
            int cur = nums[i];

            dp[i] = 1;
            count[i] = 1;

            for (int j = l - 1; j > i; j--) {
                if (cur < nums[j]) {

                    if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (dp[i] == max) {
                result += count[i];
            }
            if (dp[i] > max) {
                max = dp[i];
                result = count[i];
            }
        }
        return result;
    }

    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;

        List<int[]>[] list = new ArrayList[l];
        for (int i = 0; i < l ; i++) {
            list[i] = new ArrayList();
        }
        int idx = 0;

        for (int i = 0; i < l ; i++) {
            int cur = nums[i];

            int number = 1;

            int position = getPosition(idx, list, cur);
            List<int[]> tuples = list[position];

            if (position > 0) {
                List<int[]> prevTuples = list[position - 1];
                int prevPosition = getIndexOfGreaterElement(prevTuples, cur);
                number = prevTuples.get(prevTuples.size() - 1)[1] -
                        ( prevPosition == 0 ? 0 : prevTuples.get(prevPosition - 1 )[1]);
            }

            if (tuples.size() == 0) {
                tuples.add( new int[]{cur, number} );
                idx++;
            } else {
                int[] last = tuples.get(tuples.size() - 1);
                if (last[0] == cur) {
                    last[1] += number;
                } else {
                    tuples.add(new int[]{cur, last[1] + number});
                }
            }


        }

        return list[idx - 1].get(list[idx - 1].size() - 1)[1];
    }

    private int getIndexOfGreaterElement(List<int[]> tuples, int cur) {
        int i = 0;
        int j = tuples.size() - 1;

        while (i < j) {
            int m = (j + i) / 2;
            if (tuples.get(m)[0] >= cur ) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }


    private int getPosition(int j, List<int[]>[] list, int cur) {
        int i = 0;
        while (i < j) {
            int m = (j + i) / 2;
            if (list[m].get( list[m].size() - 1 )[0] < cur ) {
                i = m + 1;
            } else {
                j = m;
            }
        }

        return i;
    }

    Map<Integer, Integer> map;
    int[][] BIT;

    public int findNumberOfLISBIT(int[] nums) {
        build(Arrays.copyOf(nums, nums.length));
        int[] res = {0, 0};
        Arrays.stream(nums).forEach(i -> {
            int[] cur = search(map.get(i));
            update(res, cur);
            insert(map.get(i) + 1, cur);
        });
        return res[1];
    }

    private void build(int[] A) {
        Arrays.sort(A);
        map = new HashMap<>();
        Arrays.stream(A).filter(i -> !map.containsKey(i)).forEach(i -> map.put(i, map.size() + 1));
        BIT = new int[map.size() + 2][2];
    }

    private int[] search(int i) {
        int[] count = {0, 1};
        while (i > 0) {
            update(count, BIT[i]);
            i -= i & -i;
        }
        return new int[]{count[0] + 1, count[1]};
    }

    private void insert(int i, int[] cur) {
        while (i < BIT.length) {
            update(BIT[i], cur);
            i += i & -i;
        }
    }

    public void update(int[] a, int[] b) {
        if (a[0] < b[0]) {
            a[0] = b[0];
            a[1] = b[1];
        } else if (a[0] == b[0]) {
            a[1] += b[1];
        }
    }


    public int findNumberOfLISbs_(int[] nums) {
        List<List<int[]>> dp = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new int[]{Integer.MIN_VALUE, 1});
        for (int value : nums) {
            int l = 0, r = dp.size();
            while (r - l > 1) {
                int m = l + (r - l) / 2;
                List<int[]> cell = dp.get(m);
                if (cell.isEmpty() || cell.get(cell.size() - 1)[0] >= value) {
                    r = m;
                } else {
                    l = m;
                }
            }
            int cnt = 0;
            for (int[] prev : dp.get(l)) {
                if (prev[0] < value)
                    cnt += prev[1];
            }
            List<int[]> cell = dp.get(l + 1);
            if (cell.isEmpty() || cell.get(cell.size() - 1)[0] != value) {
                cell.add(new int[]{value, cnt});
            } else {
                cell.get(cell.size() - 1)[1] += cnt;
            }
        }
        for (int i = dp.size() - 1; i >= 0; i--) {
            if (!dp.get(i).isEmpty()) {
                int res = 0;
                for (int[] pair : dp.get(i)) {
                    res += pair[1];
                }
                return res;
            }
        }
        return 0; // unreachable
    }


    /*
     * nums    = [1, 3, 5, 4, 7, 5, 6]
     * buckets = [<1, 1>, <3, 1>, <5, 1>, <7, 2>, <6, 1>]
     *                            <4, 2>, <5, 3>
     * total   = [   1  ,    1  ,    2  ,    3  ,    1  ]
     */
    public int findNumberOfLIS2bs(int[] nums) {
        List<List<int[]>> buckets = new ArrayList<>();
        List<Integer> total = new ArrayList<>();

        for (int num : nums) {
            int idx = binarySearch(buckets, num);
            if (idx == buckets.size()) {
                buckets.add(new ArrayList<>());
                total.add(0);
            }
            int count;
            if (idx > 0) {
                count = total.get(idx - 1) - binarySearch2(buckets.get(idx - 1), num);
            } else {
                count = 1;
            }
            total.set(idx, total.get(idx) + count);
            buckets.get(idx).add(new int[]{num, total.get(idx)});
        }
        System.out.println(total.toString());
        return total.get(total.size() - 1);
    }

    // the idx of bucket to insert target to
    private int binarySearch(List<List<int[]>> buckets, int target) {
        int l = 0, r = buckets.size();
        while (l < r) {
            int m = (l + r) >> 1;
            List<int[]> bucket = buckets.get(m);
            if (bucket.get(bucket.size() - 1)[0] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int binarySearch2(List<int[]> bucket, int target) {
        int l = -1, r = bucket.size() - 1;
        while (l < r) {
            int m = (l + r + 1) >> 1;
            if (bucket.get(m)[0] < target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l < 0 ? 0 : bucket.get(l)[1];
    }

    public int findNumberOfLIS2bs2(int[] nums) {
        int l = nums.length;
        List<int[]>[] lists = new ArrayList[l];
        for (int i = 0; i < l; i++) {
            lists[i] = new ArrayList<>();
        }
        int size = 0;

        for (int n : nums) {
            int index = bSearchLength(lists, size, n);
            int count = 1;

            if (index > 0) {
                List<int[]> t = lists[index - 1];
                int p = bSearchIndex(t, n);
                count = t.get(t.size() - 1)[1] - (p == 0 ? 0 : t.get(p - 1)[1]);
            }
            if (lists[index].size() == 0) {
                lists[index].add(new int[]{n, count});
                size++;
            } else {
                List<int[]> t = lists[index];
                int[] last = t.get(t.size() - 1);
                int ch = last[1] + count;
                if (last[0] == n) {
                    last[1] += count;
                } else {
                    t.add(new int[]{n, last[1] + count});
                }
            }
        }
        return lists[size - 1].get(lists[size - 1].size() - 1)[1];
    }

    public int bSearchLength(List<int[]>[] lists, int right, int n) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (n > lists[mid].get(lists[mid].size() - 1)[0])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int bSearchIndex(List<int[]> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num <= list.get(mid)[0])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
