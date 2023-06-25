package com.yablokovs.leetcode.tree;

public class ValidBinarySearchTree_M_98 {


    public static void main(String[] args) {

    }
    static Integer current;

    public static boolean isValidBST(TreeNode root) {
        TreeNode left = root.left;
        if (left != null) {
            if (!isValidBST(left)) {
                return false;
            }
        }

        if (current == null) {
            current = root.val;
        } else if (current >= root.val) {
            return false;
        } else {
            current = root.val;
        }


        TreeNode right = root.right;
        if (right != null) {
            if (!isValidBST(right)) {
                return false;
            }
        }
        return true;

    }

}
