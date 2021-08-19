package Challenge.Trees;
//BFS uses a queue
//DFS uses Stack

//0. Initialize Queue
//1. Queue.offer(root) i.e. put root in Queue
//2. while (!Queue.isEmpty)
//3. Queue.poll() from the queue
//4. process current node from Queue
//5. Queue.offer() (put) children of current node to the end of the queue


//Given a root node of a Binary Tree perform the following operations.
//        1. Print Tree values in In-order
//        2. Print Tree values in Pre-order
//        3. Print Tree values in Post-order
//        4. Print Level order on same line (use BFS, single queue method)
//        5. Print Level order on separate line; each level on separate line (use BFS, two queues method)
//        6. Print Level order on separate line; each level on separate line (use BFS, single queue using count)
//        Note: There are other ways also for level traversal like using a sentinal node etc. if you want to try that.
//        https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MTYzNDU4/details


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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


/*
            0
           /  \
          1    2
         /      \
        3        4
*/
//        Node  root = new Node(0);
//        Node  node1 = new Node(1);
//        Node  node2 = new Node(2);
//        Node  node3 = new Node(3);
//        Node  node4 = new Node(4);
//
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node2.right = node4;

        /*
            0
           /  \
          1    6
         / \  / \
        2  3 7   8
       /\
      4 5
*/

          Node  root = new Node(0);
          Node  node1 = new Node(1);
          Node  node6 = new Node(6);
          Node  node2 = new Node(2);
          Node  node3 = new Node(3);
          Node  node7 = new Node(7);
          Node  node8 = new Node(8);
          Node  node4 = new Node(4);
          Node  node5 = new Node(5);

        root.left = node1;
        root.right = node6;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node6.left = node7;
        node6.right = node8;


        //levelOrder(root);
        //printlevelOrderByLvl2Queue(root); // Two Queue
        //printlevelOrderByLvl1Q1Cnt(root); //One Queue and one count
        printlevelOrderByLvl1Queue(root); // Insert a placeholder null to the queue
    }

    static void levelOrder(Node root) {

        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            //process the node - in this case we are printing it
            //in other cases we would be calculating the distances
            System.out.print(node.val + ",");

            // These are children's left and right
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

    //Use 2 queue to print by level the nodes
    //0
    //1, 6
    //2,3,7,8
    //4,5
    static void printlevelOrderByLvl2Queue(Node root) {

        Deque<Node> queue1 = new ArrayDeque<>();
        Deque<Node> queue2 = new ArrayDeque<>();

        queue1.offer(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {

            while (!queue1.isEmpty()) {
                Node node = queue1.poll();

                //process the node - in this case we are printing it
                //in other cases we would be calculating the distances
                System.out.print(node.val + ",");

                Node leftNode = node.left;
                Node rightNode = node.right;
                if (leftNode != null)
                    queue2.add(leftNode);
                if (rightNode != null)
                    queue2.add(rightNode);
            }
            System.out.println("");

            while (!queue2.isEmpty()) {
                Node node = queue2.poll();

                //process the node - in this case we are printing it
                //in other cases we would be calculating the distances
                System.out.print(node.val + ",");

                Node leftNode = node.left;
                Node rightNode = node.right;
                if (leftNode != null)
                    queue1.add(leftNode);
                if (rightNode != null)
                    queue1.add(rightNode);
            }
            System.out.println("");
        }

    }

    static void printlevelOrderByLvl1Q1Cnt(Node root) {

        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(root);
        int levelNode;
        while(!queue.isEmpty()) {

            levelNode = queue.size();
            while(levelNode > 0) {

                Node node = queue.poll();

                //process the node - in this case we are printing it
                //in other cases we would be calculating the distances
                System.out.print(node.val + ",");

                // These are children's left and right
                Node leftNode = node.left;
                Node rightNode = node.right;

                if (leftNode != null) {
                    queue.offer(leftNode);
                }
                if (rightNode != null) {
                    queue.offer(rightNode);
                }

                levelNode--;
            }
            System.out.println();
        }

    }

    static void printlevelOrderByLvl1Queue(Node root) {

        Deque<Node> queue = new LinkedList<>(); // LinkedList take a null ArrayDeque does not

        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if (node == null) {
                if (!queue.isEmpty())
                    queue.offer(null);
                //print the level and add Null
                System.out.println();
            } else {


                //process the node - in this case we are printing it
                //in other cases we would be calculating the distances
                System.out.print(node.val + ",");

                // These are children's left and right
                Node leftNode = node.left;
                Node rightNode = node.right;

                if (leftNode != null) {
                    queue.offer(leftNode);
                }
                if (rightNode != null) {
                    queue.offer(rightNode);
                }
            }
        }

    }

}
