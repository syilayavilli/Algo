package Challenge.Trees;

//Horizontal Distance (horizontalDistance) from left side will start with
//        root at zero
//        Left Child will be root - 1
//        Right Child will be root + 1
//        We will include the horizontal disatance part of the TreeNode
//Do a BFS i.e Queue and also Map to store with Key=HorizontalDistance and Value=Node Value
//Time complexity for BFS accessing all noes will be O(n) aplus for Map O(n) i.e. O(n) + O(n) = O(n)
//Space Complexity O(n) + Map O(n)
//        https://www.youtube.com/watch?v=PQKkr036wRc
//        https://www.youtube.com/watch?v=cfe0coRWjqc

//Note: For TopView we need the hashMap of the first occurrence for horizontalDistance and value
//Note: For Bottom View, we need the last occurrence i.e. we overwrite the values for each horizontalDistance the values
//      KEY- The middle nodes at same level will OVERLAP SO ONLY ONE THE LAST ONE WILL BE VISIBLE


import java.util.*;


/*

       2
      /  \
     7    3
      \    \
       6    9
      / \
     5  11
    /
   10

10, 7, 2, 3, 9

 */
public class TopBottomViewOfBinaryTree {

    private static class TreeNode {
        int val;
        int horizontalDistance;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }

    private static Map<Integer, Integer> topView(TreeNode current) {

        Map<Integer, Integer> topView = new HashMap<Integer, Integer>();
        if (current == null)
            return topView;

        Queue<TreeNode> nodalQueue = new LinkedList<TreeNode>();

        nodalQueue.offer(current);


        //This is BFS so loop through the queue and poll each one adding their children
        //Loop through queue
        while (!nodalQueue.isEmpty()) {

            current = nodalQueue.poll();

            //Only add the first one - check if does not contain a horizontalDistance key
            if (!topView.containsKey(current.horizontalDistance))
                topView.put(current.horizontalDistance, current.val);

            if (current.left != null ) {
                nodalQueue.add(current.left);
                current.left.horizontalDistance = current.horizontalDistance - 1;
            }

            if (current.right != null ) {
                nodalQueue.add(current.right);
                current.right.horizontalDistance = current.horizontalDistance + 1;
            }
        }

        return topView;
    }

    private static Map<Integer, Integer> bottomView(TreeNode current) {

        Map<Integer, Integer> bottomView = new HashMap<Integer, Integer>();
        if (current == null)
            return bottomView;

        Queue<TreeNode> nodalQueue = new LinkedList<TreeNode>();

        nodalQueue.offer(current);


        //This is BFS so loop through the queue and poll each one adding their children
        //Loop through queue
        while (!nodalQueue.isEmpty()) {

            current = nodalQueue.poll();

            //Overwrite always so we store the last one
            bottomView.put(current.horizontalDistance, current.val);

            if (current.left != null ) {
                nodalQueue.add(current.left);
                current.left.horizontalDistance = current.horizontalDistance - 1;
            }

            if (current.right != null ) {
                nodalQueue.add(current.right);
                current.right.horizontalDistance = current.horizontalDistance + 1;
            }
        }

        return bottomView;
    }


    public static void main (String[] args) {
/*
       2
      /  \
     7    3
      \    \
       6    9
      / \
     5  11
    /
   10

   */

         TreeNode root = new TreeNode(2);
         TreeNode node3 = new TreeNode(3);

         TreeNode node5 = new TreeNode(5);
         TreeNode node6 = new TreeNode(6);
         TreeNode node7 = new TreeNode(7);
         TreeNode node9 = new TreeNode(9);
         TreeNode node10 = new TreeNode(10);
         TreeNode node11 = new TreeNode(11);

         root.left = node7;
         root.right = node3;
         node7.right = node6;
         node3.right = node9;

         node6.left = node5;
         node6.right = node11;
         node5.left = node10;
        System.out.println("Top View:");
        Map<Integer, Integer> topView = topView(root);
        Collection<Integer> values = topView.values();
        for (Integer s: values)
            System.out.print(s + ",");

        System.out.println();
        System.out.println("Bottom View:");

        Map<Integer, Integer> bottomView = bottomView(root);
        values = bottomView.values();

        for (Integer s: values)
            System.out.print(s + ",");
    }
}
