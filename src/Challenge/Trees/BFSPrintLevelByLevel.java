package Challenge.Trees;
//BFS uses a queue
//DFS uses Stack

//0. Initialize Queue
//1. Queue.offer(root) i.e. put root in Queue
//2. while (!Queue.isEmpty)
//3. Queue.poll() from the queue
//4. process current node from Queue
//5. Queue.offer() (put) children of current node to the end of the queue

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class BFSPrintLevelByLevel {

    public static void main(String[] args ) {

        Node  root = new Node(0);
        Node  node1 = new Node(1);
        Node  node2 = new Node(2);
        Node  node3 = new Node(3);
        Node  node4 = new Node(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        levelOrder(root);
    }

    static void levelOrder(Node root) {

        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            //process the node - in this case we are printing it
            //in other cases we would be calculating the distances
            System.out.println(node.val);

            // These are childrens lft and right
            Node leftNode = node.left;
            Node rightNode = node.right;

            if(leftNode != null) {
                queue.offer(leftNode);
            }
            if(rightNode != null) {
                queue.offer(rightNode);
            }
        }

    }
}
