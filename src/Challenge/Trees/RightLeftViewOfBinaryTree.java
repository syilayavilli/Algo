package Challenge.Trees;

// Has both Right View and Left View


//Given the root of a binary tree, imagine yourself standing on the right side of it,
//        return the values of the nodes you can see ordered from top to bottom.
//        Input: root = [1,2,3,null,5,null,4]
//        Output: [1,3,4]

/*
      1
     / \
    2   3
    \    \
    5     4
 */

//        Input: root = [1,null,3]
//        Output: [1,3]

//        Input: root = []
//        Output: []

// Use BFS i.e. Queue offer (add) poll (remove)
// In each level the last item is the one that comes in view
// Collect all the last node at each level into an array list that can be returned.
// We will be traversing all the nodes.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightLeftViewOfBinaryTree {

    private static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }

    public static List<TreeNode> rightSideView(TreeNode current) {

        List<TreeNode> visibleValues = new ArrayList<TreeNode>();

        if (current == null) {
            return visibleValues;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(current);
        while (!queue.isEmpty() ) {

            int size = queue.size();

            //Process through Queue size and include the last one to the visible list
            for (int i = 0; i < size; i++) {

                current = queue.poll();
                if (i == size - 1) {
                    visibleValues.add(current);
                }

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
        }
        return visibleValues;
    }

    public static List<TreeNode> leftSideView(TreeNode current) {

        List<TreeNode> visibleValues = new ArrayList<TreeNode>();

        if (current == null) {
            return visibleValues;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(current);
        while (!queue.isEmpty() ) {

            int size = queue.size();

            //Process through Queue size and include the last one to the visible list
            for (int i = 0; i < size; i++) {

                current = queue.poll();
                if (i == 0) {
                    visibleValues.add(current);
                }

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
        }
        return visibleValues;
    }


    public static void main(String[] args) {
        /*
      1
     / \
    2   3
    \    \
    5     4
    */

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.right = node5;
        node3.right = node4;

        List<TreeNode> visibleValues = rightSideView(root);

        System.out.print("Right Side Views: ");
        for (int i = 0; i< visibleValues.size(); i++)
            System.out.print(visibleValues.get(i).val + ",");

        System.out.println();

        visibleValues = leftSideView(root);
        System.out.print("Left Side Views: ");
        for (int i = 0; i< visibleValues.size(); i++)
            System.out.print(visibleValues.get(i).val + ",");
    }
}
