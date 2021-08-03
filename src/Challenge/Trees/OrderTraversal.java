package Challenge.Trees;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

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

        printInOrder(root);
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
}
