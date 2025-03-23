package com.yablokovs.leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SnakeAndLadders {
    int[] a;
    boolean[] visit;
    int l;
    int L;
    public int snakesAndLadders(int[][] board) {
        l = board.length;
        L = l * l;
        a = new int[L];
        visit = new boolean[L];
        // Arrays.fill(dp, 1000); // not using prie

        boolean odd = l % 2 == 1;
        int ix = 0;
        for (int i = l - 1; i >= 0; i--) {
            int remove = l - 1;
            if ( odd && i % 2 == 0 || !odd && i % 2 == 1)
                remove = 0;
            for (int j = 0; j < l; j++) {
                int temp = Math.abs(j - remove);
                a[ix++] = board[i][temp];
            }
        }
        System.out.println(Arrays.toString(a));
        // bfs(0, 0);

        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
        visit[0] = true; // visited

        int step = 0;
        int size;
        while( (size = q.size()) > 0 ) {
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == L - 1) return step;

                if (a[cur] != -1 ) { // NOT -1 in cur cell
                    int target = a[cur] - 1;
                    if (visit[target]) continue;
                    q.offer(target);
                    visit[target] = true;
                } else {
                    for (int j = 1; j < 7; j++) {
                        int target = cur + j;
                        if (target >= L) break;
                        if (visit[target]) continue;


                        if (a[target] != -1) { // NOT -1
                            if (!visit[a[target] - 1]) {
                                q.offer(a[target] - 1);
                                visit[a[target] - 1] = true;
                            }

                        } else {
                            if (!visit[target]) {
                                q.offer( target );
                                visit[target] = true;
                            }
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }


    public String customSortString(String order, String s) {
        char[] str = s.toCharArray();
        char[] ord = order.toCharArray();

        // Arrays.stream(ord).collect(Collectors.toMap())
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ord.length; i++) {
            char c = ord[i];
            map.put(c, i);
        }
        Character[] charObjectArray = new Character[str.length];
        for (int i = 0; i < str.length; i++) {
            charObjectArray[i] = str[i];
        }

        Arrays.sort(charObjectArray,
                (a, b) -> map.containsKey(a) && map.containsKey(b) ?
                        Integer.compare(map.get(a), map.get(b)) :
                        1
        );

        return new String(str);
    }

}
