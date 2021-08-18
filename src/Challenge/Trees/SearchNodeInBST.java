package Challenge.Trees;

/*
       4
      / \
     2   7
    / \
   1   3

   Search for Node 2
   Output:
    2
   / \
  1   3
 */

public class SearchNodeInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode searchBST(TreeNode node, int val)
    {
        if (node == null)
            return null;

        if (node.val == val)
            return node;

        if (val > node.val ) {
            return searchBST(node.right, val);
        } else
            return searchBST(node.left, val);
    }

    public static void main(String[] args) {
        /*
               4
              / \
             2   7
            / \
           1   3

         */

        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;

        TreeNode node = searchBST(root, 2);
        if (node != null)
            System.out.println("node value: " + node.val);
        if (node.left != null)
            System.out.print(" left child: " + node.left.val) ;
        if (node.right != null)
            System.out.print(" right child: " + node.right.val);

    }
}
