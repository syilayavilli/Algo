package Challenge.Trees;

//Get Diagonal Sum of Binary Tree
//Use BFS
//use the horizontalDistance
//  Root Node d = 0
//  Right Node will not increment d = d(parent) and will remain the same as the parent
//  Left Node will increment by one d = d(parent) + 1 from the parent
//  HashMap horizontalDistances and accumulate all the nodes against them

/*
                       1 (d=0)
                      /    \
                     /      \
                    /        \
                   /          \
                  /            \
            (d=1) 2             3(d=0)
               /   \          /     \
         (d=2)4     5(d=1)  6(d=1)  7 (d=0)
             /  \            /  \      \
       (d=3)8    9(d=2) (d=2)10 11(d=1) 12 (d=0)
           / \              / \           /   \
     (d=4)13 14(d=3)  (d=3)15  16(d=2) (d=1)17  18(d=0)

 */

import java.util.*;

public class DiagonalSumBinaryTree {

    private static class TreeNode {
        int val;
        int horizontalDistance = 0;

        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static Map<Integer, Integer> diagonalSum(TreeNode current) {

        Map<Integer, Integer> diagonalSum = new HashMap<Integer, Integer>();

        if (current == null)
            return diagonalSum;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(current);

        //Keep processing the queue until empty
        while (!queue.isEmpty()) {

            current = queue.poll();

            //Integer compute = (diagonalSum.get(current.horizontalDistance) == null) ? 0 : diagonalSum.get(current.horizontalDistance)  + current.val;
            diagonalSum.put(current.horizontalDistance, (diagonalSum.get(current.horizontalDistance) == null) ? current.val : diagonalSum.get(current.horizontalDistance)  + current.val);

            if (current.left != null) {
                current.left.horizontalDistance = current.horizontalDistance + 1;
                queue.offer(current.left);
            }

            if (current.right != null) {
                current.right.horizontalDistance = current.horizontalDistance;
                queue.offer(current.right);
            }
        }

        return diagonalSum;
    }

    public static void main(String[] args) {

        /*
                       1 (d=0)
                      /    \
                     /      \
                    /        \
                   /          \
                  /            \
            (d=1) 2             3(d=0)
               /   \          /     \
         (d=2)4     5(d=1)  6(d=1)  7 (d=0)
             /  \            /  \      \
       (d=3)8    9(d=2) (d=2)10 11(d=1) 12 (d=0)
           / \              / \           /   \
     (d=4)13 14(d=3)  (d=3)15  16(d=2) (d=1)17  18(d=0)

 */

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        TreeNode node16 = new TreeNode(16);
        TreeNode node17 = new TreeNode(17);
        TreeNode node18 = new TreeNode(18);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node8;
        node4.right = node9;
        node8.left = node13;
        node8.right = node14;

        node3.left = node6;
        node3.right = node7;

        node6.left = node10;
        node6.right = node11;

        node7.right = node12;

        node10.left = node15;
        node10.right = node16;

        node12.left = node17;
        node12.right = node18;

        Map<Integer, Integer> diagonalSum = diagonalSum(root);
        Collection<Integer> keyset = diagonalSum.keySet();
        for (Integer key: keyset)
            System.out.println("Diagonal Key : " + key + " Value: " + diagonalSum.get(key));

    }
}
