package Challenge.Trees;

//class Node {
//    int val;
//    Node left;
//    Node right;
//
//    Node(int val) {
//        this.val = val;
//    }
//}

public class OrderTraversal {

    public static void main(String[] args ) {

/*
            0
           /  \
          1    2
         /      \
        3        4
*/
        Node  root = new Node(0);
        Node  node1 = new Node(1);
        Node  node2 = new Node(2);
        Node  node3 = new Node(3);
        Node  node4 = new Node(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        //printInOrder(root);
        //printPreOrder(root);
        printPostOrder(root);
    }

    static void printInOrder(Node node) {
        //base condition
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.print(node.val + ",");
        printInOrder(node.right);
    }

    static void printPreOrder(Node node) {

        //base condition
        if (node == null) {
            return;
        }

        //process the current node
        System.out.println(node.val + ",");

        //print the left
        printPreOrder(node.left);

        //print the right
        printPreOrder(node.right);

    }

    static void printPostOrder(Node node) {

        //base condition
        if (node == null) {
            return;
        }

        //print the left
        printPreOrder(node.left);

        //print the right
        printPreOrder(node.right);

        //process the current node
        System.out.println(node.val + ",");

    }
}
