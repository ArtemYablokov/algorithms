package com.yablokovs.LC_v3.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeOperations_1993 {
    int[] locked;
    // int[] unlocked; // state of node

    Set<Integer>[] anc; // anc for each node
    Set<Integer>[] desc; // desc for each node
    Set<Integer>[] lockedAnc;
    Set<Integer>[] lockedDesc;

    public boolean lock(int num, int user) {
        if (locked[num] == 0) {
            locked[num] = user;
            addLockedAnc(num);
            addLockedDesc(num);
            return true;
        }
        return false;

    }

    private void addLockedAnc(int n) {
        Set<Integer> descCur = desc[n];
        for (int d : descCur) {
            lockedAnc[d].add(n);
        }
    }

    private void addLockedDesc(int n) {
        Set<Integer> ancCur = anc[n];
        for (int a : ancCur) {
            lockedDesc[a].add(n);
        }
    }

    public boolean unlock(int num, int user) {
        if (locked[num] != user)
            return false;
        locked[num] = 0;
        removeLockedAnc(num);
        removeLockedDesc(num);
        return true;
    }

    private void removeLockedAnc(int n) {
        Set<Integer> descCur = desc[n];
        for (int d : descCur) {
            lockedAnc[d].remove(n);
        }
    }

    private void removeLockedDesc(int n) {
        Set<Integer> ancCur = anc[n];
        for (int a : ancCur) {
            lockedDesc[a].remove(n);
        }
    }

    public boolean upgrade(int num, int user) {
        if (locked[num] != 0)
            return false;
        if (lockedDesc[num].size() == 0)
            return false;
        if (lockedAnc[num].size() != 0)
            return false;

        // unlock all curDesc.
        // for all DESC clear lockDesc
        // for all DESC remove curDesc from lockedAnc
        // for all DESC add cur as a lockedAnc
        updateCurDesc(desc[num], num);

        // for all ANC remove curDesc from lockedDesc
        // for all ANC add cur as a lockedDesc
        updateCurAnc(anc[num], desc[num], num);

        locked[num] = user;
        return true;
    }

    void updateCurDesc(Set<Integer> curDesc, int cur) {
        for (int d : curDesc) {
            locked[d] = 0;
            lockedDesc[d].clear();
            lockedAnc[d].removeAll(curDesc);
            lockedAnc[d].add(cur);
        }
    }

    void updateCurAnc(Set<Integer> curAnc, Set<Integer> curDesc, int cur) {
        for (int a : curAnc) {
            lockedDesc[a].removeAll(curDesc);
            lockedDesc[a].add(cur);
        }
    }

    Map<Integer, List<Integer>> map = new HashMap<>(); // only for building anc and desc
    int l;

    public TreeOperations_1993(int[] parent) {
        l = parent.length;
        locked = new int[l];
        // unlocked = new int[l];
        anc = new HashSet[l];
        desc = new HashSet[l];
        lockedAnc = new HashSet[l];
        lockedDesc = new HashSet[l];
        for (int i = 0; i < l; i++)
            map.put(i, new ArrayList<Integer>());
        for (int i = 0; i < l; i++) {
            // anc[i] = new ArrayList<>();
            // desc[i] = new ArrayList<>();
            lockedAnc[i] = new HashSet<>();
            lockedDesc[i] = new HashSet<>();
        }
        addChilds(parent);
        List<Integer> list = populateAncAndDesc(new ArrayList<>(), 0);
        anc[0] = new HashSet<>();
//        desc[0] = list;
//        desc[0].remove(desc[0].size() - 1);
    }

    private List<Integer> populateAncAndDesc(List<Integer> curAnc, int cur) {
        anc[cur] = new HashSet<>(curAnc);
        curAnc.add(cur);

        List<Integer> curDesc = new ArrayList<>();
        for (int child : map.get(cur)) {
            List<Integer> temp = populateAncAndDesc(curAnc, child);
            curDesc.addAll(temp);
        }
        curAnc.remove(curAnc.size() - 1);
        desc[cur] = new HashSet<>(curDesc);
        curDesc.add(cur);
        return curDesc;
    }

    private void addChilds(int[] parent) {
        for (int i = 1; i < l; i++) {
            map.get(parent[i]).add(i);
        }
    }


/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
}
