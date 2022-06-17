package Challenge.Trees;

//Check if the value to delete is less or greater than root value
//        if greater move to right else left
//3 scenarios
//1. Delete has no child
//2. Node has one child
//3. Node has both
//Delete the node and find the inorder successor
//After deleting the node we have to maintain the BST properties


//https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

/*
         4
       /   \
      2     6
     / \   / \
    1   3 5   7
 */

public class DeleteANodeFromBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode deleteNodeBST(TreeNode node, int val) {

        //If the root node or leaf node and we need to go back
        //the below helps
        if(node == null) {
            return null;
        }

        //start searching for the TreeNode
        //If the value is greater root search the right see
        if (val < node.val) {
            node.left = deleteNodeBST(node.left, val);
        } else if (val > node.val) {
            node.right = deleteNodeBST(node.right, val);
        } else { //found the node
              /*
                 if (node.left == null and node.right == null) {
                 {
                    return null;
                 }
               */
            //Apply The three cases

            if (node.left == null) {
                return node.right; //this could be null as well
            } else if (node.right == null) {
                return node.left; //this could be null as well
            } else { // has both child
                //Get the successor or predecessor
                int minValue = minValue(node.right); // or maxValue(node.left)
                //The currentNode value should be this new value
                node.val = minValue;

                //delete the node recursively
                node.right = deleteNodeBST(node.right, minValue);
            }
        }
        return node;
    }

    //Get the minimum value from a BST
    public static int minValue(TreeNode node) {
        int minValue = node.val;

        for(; node!=null; node = node.left) {
            minValue = node.val;
        }
        return minValue;
    }

    //you can also get the maxValue
    //Get the minimum value from a BST
    public static int maxValue(TreeNode node) {
        int maxValue = node.val;

        for(; node!=null; node = node.right) {
            maxValue = node.val;
        }
        return maxValue;
    }

    public static void main(String[] args){

      /* Delete 20 a leaf node with no child
          50
         /   \
       30     70
      /  \   /  \
     20  40  60 80

            Delete a node 30 which has one child
            50
          /    \
         30    70
           \   / \
           40 60 80

            Delete a node 50 which has two child
             50                    60
            /  \                  /  \
           40   70               40  70
               /  \                    \
              60   80                  80
       */

        TreeNode root = new TreeNode(50);
        TreeNode node30 = new TreeNode(30);
        TreeNode node70 = new TreeNode(70);
        TreeNode node20 = new TreeNode(20);
        TreeNode node40 = new TreeNode(40);
        TreeNode node60 = new TreeNode(60);
        TreeNode node80 = new TreeNode(80);

        root.left = node30;
        root.right = node70;
        node30.left = node20;
        node30.right = node40;
        node70.left = node60;
        node70.right = node80;

        TreeNode deleteNode20 = deleteNodeBST(root, 20);
        if (deleteNode20.left != null)
            System.out.print(" deleteNode20 -- Parent Node should be 30 ..." + deleteNode20.left.val);
        if (deleteNode20.left.left == null)
            System.out.print(" Parent Node left Node 20 removed...");
        if (deleteNode20.right != null)
            System.out.print(" Parent Node right be 40 ..." + deleteNode20.left.right.val);

        System.out.println();
        TreeNode deleteNode30 = deleteNodeBST(root, 30);

        if (deleteNode30.left != null)
            System.out.print(" deleteNode30 -- Parent Node should now become from 30 ..." + deleteNode30.left.val);
        if (deleteNode30.left.left == null)
            System.out.print(" Parent Node left Node was removed...");
        if (deleteNode30.left.right == null)
            System.out.print(" Parent Node right was removed ..." );

        System.out.println();
        TreeNode deleteNode50 = deleteNodeBST(deleteNode30, 50);


        if (deleteNode50 != null)
            System.out.print("deleteNode50 -- Root Node should now change from 50 ..." + deleteNode30.val);
        if (deleteNode50.left != null)
            System.out.print(" deleteNode50 -- Left of Root Node ..." + deleteNode50.left.val);
        if (deleteNode50.right != null)
            System.out.print(" deleteNode50 -- Right of Root Node ..." + deleteNode50.right.val);

    }
}
