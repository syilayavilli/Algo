package Challenge.Trees;

public class InsertNodeInABST {

    private static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static TreeNode insertBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        /*
           8
          /  \
         3     10
        / \      \
       1   6      14
          / \      /
         4   7    13
         */

        TreeNode root = new TreeNode(8);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        TreeNode node13 = new TreeNode(13);

        root.right = node10;
        root.left = node3;
        node10.right = node14;
        node14.left = node13;
        node3.left = node1;
        node3.right = node6;
        node6.left = node4;
        node6.right = node7;

        /*
               4
              / \
             2   7
            / \
           1   3

           insert 5

                4
               /  \
              2    7
             / \   /
            1   3  5


             5
            / \
           2   7
          / \
         1   3
              \
               4
         */
           TreeNode node2 = new TreeNode(2);
           root = node4;
           root.left = node2;
           root.right = node7;
           node2.left = node1;
           node2.right = node3;


           TreeNode resultNode = insertBST(root, 5);

           System.out.print("Parent: " + resultNode.right.val + " Added one is to the left " + resultNode.right.left.val);
    }
}
