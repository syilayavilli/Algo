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
//postorder = [9,15,7,20,3], inorder = [9,3,15,20,7]
//occurrence of index in post order from the left sub tree or right subtree
//The key here is to pick the root for the left. For right root it is from the end of postorder (L R C)
//so for right subtree root, we just decrement the postorder array from the end
//for left subtree node this is what needs to happen - we need to find hown much left we need to move from the end of preorder array
//from the end post-array-index 4, we need to move number of nodes that was used by right sub tree which we can get from inorder which is
//end of inorder - index in this case it will 3 nodes ()15,20,7) so we need to subtract from end of postorder by 3 and one further to pick the left root
//cause postorder is Left Right Center - in postorder leave the last cell which is the root travers left by number of nodes and subtract 1 to get the left root
// For Postorder check https://www.youtube.com/watch?v=TblhNX9AQ3M at 5:09


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
    public static TreeNode buildPostorder(int[] postorder, int[] inorder, int inStart, int inEnd, int postIndex) {

        //base condition - The start index of both preorder and inorder (in this case) do not exceed end index
        if (inStart > inEnd) return null;

        //Start the treeNode with root
        TreeNode root = new TreeNode(postorder[postIndex]);

        if (root == null)
            return null;

        // This will happen for 5 and 7
        if (inStart == inEnd)
            return root;

        //With root node in place get the index for left tree and right tree
        //Find the index of the root from inorder (LCR) the ones on the left of C is left sub tree and on the right of C is right subtree

        int index = inorderMap.get(root.val);

        //Since PostOrder is Left-Right-Center so the Post Index for Right Subtree root will be decreasing from the end of postOrder
        root.right = buildPostorder(postorder, inorder, index+1, inEnd, postIndex-1);

        //Since PostOrder is Left-Right-Center, so the POst Index doe the left Subtree root will be from the end of postOrder
        //reduce the number of nodes that was used up by the right subtree minus one will begin the left subtree node
        //inEnd - index will ne the number of node used by right subtree and subtract that from postIndex-1
        //cause postIndex was used by this child's root
        root.left = buildPostorder(postorder, inorder, inStart, index-1, (postIndex - 1) - (inEnd - index));


        return root;
    }


    public static TreeNode buildTreeFromPostOrder(int[] postorder, int[] inorder) {

        preorderIndex = inorder.length -1;
        for (int i = 0; i<inorder.length; i++)
            inorderMap.put(inorder[i], i);

        //Build the entire tree of the inorder so start from 0 till the end
        int start = 0;
        int end = inorder.length-1;
        return buildPostorder(postorder, inorder, start, end, postorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
        System.out.println("Root: " + root.val + " Root Left: " + root.left.val + " Root Right: " + root.right.val);
        //draw the rest of the tree

        //TreeNode
                root = buildTreeFromPostOrder(postorder,inorder);
        System.out.println("Root: " + root.val + " Root Left: " + root.left.val + " Root Right: " + root.right.val);
    }

}
