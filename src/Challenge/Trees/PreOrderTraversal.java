package Challenge.Trees;

//Write a function to traverse a Binary tree in PreOrder, without using recursion. As you traverse,
//        please print contents of the nodes.
//        Hint: Use Stack
//https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/


import java.util.Stack;

public class PreOrderTraversal {

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /* Construct the following tree -- CLR - DFS - Center Left Right
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        preorderRecursive(root);
        preorderIterative(root);

    }

    // Recursive function to perform preorder traversal on the tree
    public static void preorderRecursive(Node root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }

        // Display the data part of the root (or current node)
        System.out.print(root.val + " ");

        // Traverse the left subtree
        preorderRecursive(root.left);

        // Traverse the right subtree
        preorderRecursive(root.right);
    }

    // Iterative function to perform preorder traversal on the tree
    public static void preorderIterative(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }

        // create an empty stack and push the root node
        Stack<Node> stack = new Stack();
        stack.push(root);

        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and print it
            Node curr = stack.pop();

            System.out.print(curr.val + " ");

            // push the right child of the popped node into the stack
            if (curr.right != null) {
                stack.push(curr.right);
            }

            // push the left child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }

            // the right child must be pushed first so that the left child
            // is processed first (LIFO order)
        }
    }
}
