package Challenge.Trees;

//Given Two Binary trees are they identical
//The Left Sub tree should match the left sub tree and the right sub tree must match right subtree
//The values are same
//Root Node of both are same
//Left Subtree should match
//Right Subtree should match
//If left node has children or not in either case and they have to match
//If right node has children or not should match to the right tree

//Brute Force to use any order traversal


public class IsBinaryIdentical {

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

    }

    //Brute force
    public static boolean isIdentical (Node node1Tree, Node node2Tree) {

        //Check with interviewer is this needs to
//        if (node1Tree == null || node2Tree == null)
//            return false;

        if (node1Tree.val != node2Tree.val)
            return false;

        if (node1Tree.left == null && node2Tree.left != null || node1Tree.left != null && node2Tree.left == null)
            return false;
        if (node1Tree.right == null && node2Tree.right != null || node1Tree.right != null && node2Tree.right == null)
            return false;

        boolean isIdentical = true;
        if (node1Tree.left != null && node2Tree.left != null)
            isIdentical =  isIdentical(node1Tree.left, node2Tree.left);

        if (node1Tree.right != null && node2Tree.right != null)
            isIdentical= isIdentical & isIdentical(node1Tree.right, node2Tree.right);


        return isIdentical;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              /\   /\
             4  5 6  7
         */

        Node root1 = new Node(1);
        Node root2 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node33 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node nodex = new Node(-1);

        root1.left = node2;
        root1.right = node3;
        root2.left = node2;
        //root2.right = node33;  //Error Case
        root2.right = node3;  //Good Case
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node33.left = node6;
        node33.right = nodex;

        System.out.println(isIdentical(root1, root2));

    }
}
