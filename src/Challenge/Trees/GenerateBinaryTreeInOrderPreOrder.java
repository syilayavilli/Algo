package Challenge.Trees;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
//        is the inorder traversal of the same tree, construct and return the binary tree.
// Generate a Binary Tree given Inorder or Pre-Order. Assume duplicates don't' exist.
// Uses Recursion - Find root and then build subtrees
// Root cannot be found from inorder only for preorder (first) or postorder (last)
// Use hashmap to keep the indexes of the inorder in order to get the set of numbers using indexes
// Use an index to start with root from the preorder
//https://www.youtube.com/watch?v=PoBGyrIWisE - Explaination
//https://www.youtube.com/watch?v=FBpQEQkQ1No

// Time Complexity is O(n) as we traverse both the arrays once
// Space Complexity is O(n) and recursion stack has O(n) where n is the depth

//input preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3], inorder = [9,3,15,20,7] --- Note: this implementation is icorrect - we need to pick the first
//occurrence of index in post order from the left sub tree or right subtree


import java.util.HashMap;
import java.util.Map;

public class GenerateBinaryTreeInOrderPreOrder {

    // Tree node definition
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    private static Map<Integer, Integer> inorderMap = new HashMap<>();
    private static int preorderIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i<inorder.length; i++)
            inorderMap.put(inorder[i], i);


        //Build the entire tree of the inorder so start from 0 till the end
        int start = 0;
        int end = inorder.length-1;
        return build(preorder, inorder, start, end);
    }


    // For preorder scan for root from left to right
    public static TreeNode build(int[] preorder, int[] inorder, int start, int end) {

        //base condition - The start index of both preorder and inorder (in this case) do not exceed end index
        if (start > end) return null;

        //Start the treeNode with root
        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        if (root == null)
            return null;

        // This will happen for 5 and 7
        if (start == end)
            return root;

        //With root node in place get the index for left tree and right tree
        //Find the index of the root from inorder (LCR) the ones on the left of C is left sub tree and on the right of C is right subtree

        int index = inorderMap.get(root.val);

        root.left = build(preorder, inorder, start, index-1);
        root.right = build(preorder, inorder, index+1, end);

        return root;
    }


    // For preorder scan for root from left to right
    public static TreeNode buildPostorder(int[] postorder, int[] inorder, int start, int end) {

        //base condition - The start index of both preorder and inorder (in this case) do not exceed end index
        if (start > end) return null;

        //Start the treeNode with root
        TreeNode root = new TreeNode(postorder[preorderIndex--]);

        if (root == null)
            return null;

        // This will happen for 5 and 7
        if (start == end)
            return root;

        //With root node in place get the index for left tree and right tree
        //Find the index of the root from inorder (LCR) the ones on the left of C is left sub tree and on the right of C is right subtree

        int index = inorderMap.get(root.val);

        root.left = buildPostorder(postorder, inorder, start, index-1);
        root.right = buildPostorder(postorder, inorder, index+1, end);

        return root;
    }


    public static TreeNode buildTreeFromPostOrder(int[] postorder, int[] inorder) {

        preorderIndex = inorder.length -1;
        for (int i = 0; i<inorder.length; i++)
            inorderMap.put(inorder[i], i);

        //Build the entire tree of the inorder so start from 0 till the end
        int start = 0;
        int end = inorder.length-1;
        return buildPostorder(postorder, inorder, start, end);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        //TreeNode root = buildTree(preorder,inorder);
        //System.out.println("Root: " + root.val + " Root Left: " + root.left.val + " Root Right: " + root.right.val);
        //draw the rest of the tree

        TreeNode
                root = buildTreeFromPostOrder(postorder,inorder);
        System.out.println("Root: " + root.val + " Root Left: " + root.left.val + " Root Right: " + root.right.val);
    }

}
