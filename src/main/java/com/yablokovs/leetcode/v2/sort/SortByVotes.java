package com.yablokovs.leetcode.v2.sort;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByVotes {

    public String rankTeams(String[] votes) {
        Letter[] counter = new Letter[26];
        for (int i = 0; i < 26; i++) {
            counter[i] = new Letter( (char) (i + 'A') );
        }

        int l = votes[0].length();

        for (String v : votes) {
            char[] chars = v.toCharArray() ;
            for (int i = 0; i < l; i++) {
                char cur = chars[i];
                counter[cur - 'A'].list.add(i);
            }
        }
        for (Letter let : counter) {
            Collections.sort(let.list);
        }

        Arrays.sort(counter, (a, b) -> {
            List<Integer> alist = a.list;
            List<Integer> blist = b.list;
            if ( alist.size() == blist.size() ) {
                for (int i = 0; i < blist.size(); i++) {
                    if ( alist.get(i) < blist.get(i) ) {
                        return -1;
                    }
                    if ( blist.get(i) < alist.get(i) ) {
                        return 1;
                    }
                }
                return a.c - b.c;
            } else
                return blist.size() - alist.size();
        });

        char[] result = new char[l];
        int ix = 0;
        for (int i = 0; i < 26; i++) {
            Letter temp = counter[i];
            if (temp.list.size() == 0) continue;
            result[ix++] = temp.c;
        }

        return new String(result);

    }

    @ToString
    class Letter {
        char c;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int votes = 0;

        public Letter(char c) {
            this.c = c;
        }
    }

}
