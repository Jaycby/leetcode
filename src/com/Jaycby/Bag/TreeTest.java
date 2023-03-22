package com.Jaycby.Bag;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName TreeTest
 * @Author cby
 * @Date 2023/3/19 17:21
 * @Version 1.0
 */
public class TreeTest {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        boolean symmetric2 = isSymmetric2(root);
        System.out.println(symmetric2);
    }

    public static boolean isSymmetric2(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        stack.push(null);
        stack.push(root);

        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

