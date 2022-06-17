package Challenge.Trees;

//Validate Binary Search Tree


//Very common mid-tier interview question.
//https://leetcode.com/problems/validate-binary-search-tree/discuss/32104/c-in-order-traversal-and-please-do-not-rely-on-buggy-int_max-int_min-solutions-any-more

//A tree is a balanced Search Tree if
//1. The left child node is lesser than the current node
//2. The right child node is greater than the current node
//3. Both the left and right sub trees must be a BST

//Check: https://leetcode.com/problems/validate-binary-search-tree/solution/

/* No BST cause 4 is less than 5
     5
     /\
    1  4
       /\
       3 6
 */

/* Not BST cause 4 is less than 5
so we need to keep both upper limit and lower limit
       5
       /\
      1  6
         /\
        4  7
 */

//NOTE: Check Morris Traversal

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class IsBSTTree {

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /*
            2
           / \
          1   3

         */

//        Node root = new Node(2);
//        Node node1 = new Node(1);
//        Node node3 = new Node(3);
//
//        root.left = node1;
//        root.right = node3;
//
//        //System.out.println(isBST(root));
//        System.out.println(isValidBST1(root));


        /* No BST cause 4 is less than 5
             5
             /\
            1  4
               /\
               3 6
        */

//        Node root = new Node(5);
//        Node node1 = new Node(1);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node6 = new Node(6);
//
//        root.left = node1;
//        root.right = node4;
//        node4.left = node3;
//        node4.right = node6;
//        System.out.println(isValidBST1(root));


        /* Not BST cause 4 is less than 5
           so we need to keep both upper limit and lower limit
       5
       /\
      1  6
         /\
        4  7
        */

        Node root = new Node(5);
        Node node1 = new Node(1);
        Node node7 = new Node(7);
        Node node4 = new Node(4);
        Node node6 = new Node(6);

        root.left = node1;
        root.right = node6;
        node6.left = node4;
        node6.right = node7;
        //System.out.println(isValidBST1(root));

        System.out.println(isValidBST2(root));
    }

    public static boolean isBST(Node node) {
        Stack<Node> stack = new Stack<Node>();
        double leftNodeMinVale = - Double.MIN_VALUE;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (node.val <= leftNodeMinVale) return false;
            leftNodeMinVale = node.val;

            node = node.right;

        }
        return true;
    }

    public static boolean validate(Node root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public static boolean isValidBST1(Node root) {
        return validate(root, null, null);
    }



    private static Deque<Node> stack = new LinkedList();
    private static Deque<Integer> upperLimits = new LinkedList();
    private static Deque<Integer> lowerLimits = new LinkedList();

    public static boolean isValidBST2(Node root) {
        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.val;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }
    public static void update(Node root, Integer low, Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

}
