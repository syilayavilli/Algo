package Challenge.Trees;

//Print all Nodes at Level K from the root

// Solution 1 - DFS without using stack
// Solution 2 - DFS using stack - Why do we need to use stack?
// Solution 3 - BFS using Queue (A binary tree  is an acyclic connected graph and directed)
//        3
//    5         7
//  6    2    0   8
//      7  4
//
//Start node 5 wth K = 2 the answer is 7, 4 and 2
//We need to do a bidirectional search on a tree using hashtable
// We cant go upwards from 5 to 3 to 2, so we need to know the prent and their children
// so we would need to have an hashmap - we need to know who is the parent of each node
// we will do a Breadth First Search first - so we will use a Queue - First in First out
// FIFO on the other hand a stack (our stack or call stack) for a DFS Depth First Search.
//We will include a seen hash to convert this directional tree to a undirectional one
//to help to go back or forward
//need to know the current level so that on level K we want to know all the nodes in that level
//so what we need is CurrentLevel, Seen, Queue
//for the above problem K = 2
// first step is to convert this to an undirected graph by creating a map.
// Start with first node and add to queue and to seen hash table
// start with node say 5 pull out from queue and add its children and parent if not already seen
/*

   https://www.youtube.com/watch?v=nPtARJ2cYrg
   start current level with 0
   5 not seen add to queue and add to seen
   pop out 5 and add its children if not seen and update seen
   add 5's parent if not already seen to queue and update seen
   current level 0 to 1 Queue will have 6, 2 and 3

   next level - process three nodes
   pop out 6 no children and parent is already seen
   popout 2 add 7 and 4 and parent 5 is laready seen
   popout 3 5 seen 1 not seen and 3 has no parent

   level 2 (k = 2) - 7 4 1  this is the answer
   T = O(m + n ) BFS - number of edges m + number of nodes n
   in a tree number of edges will always be number of nodes - 1
   m = n - 1
   so Time = O(m + n) = O(n-1 + n) = O(n)
   Space = O(n) hashmap stores n potential nodes in a tree
   priority queue is upperbounded by number of nodes 

 */



public class PrintNodeAtLevelK {

    private static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char val) {
            this.val = val;
        }
    }

    // Navigate through all the nodes CLR - PreOrder traversal
    // decrement the levelK till this reaches to 0 when K level is navigated
    private static void printNodeK(TreeNode root, int levelK) {

        if (root == null)
            return ;

        if (levelK == 0)
            System.out.print(root.val);
        else {
            printNodeK(root.left, levelK-1);
            printNodeK(root.right, levelK-1);
        }

        return;
    }

    public static void main(String[] args) {

/*
         a
        /  \
       b     c
      / \   / \
     d   e  f  g
     /\     /\
    h  i    l   m


 */

        TreeNode root = new TreeNode('a');
        TreeNode nodeb = new TreeNode('b');
        TreeNode nodec = new TreeNode('c');
        TreeNode noded = new TreeNode('d');
        TreeNode nodee = new TreeNode('e');
        TreeNode nodef = new TreeNode('f');
        TreeNode nodeg = new TreeNode('g');
        TreeNode nodeh = new TreeNode('h');
        TreeNode nodei = new TreeNode('i');
        TreeNode nodel = new TreeNode('l');
        TreeNode nodem = new TreeNode('m');

        root.left = nodeb;
        root.right = nodec;
        nodeb.right = nodee;
        nodeb.left = noded;
        noded.left = nodeh;
        noded.right = nodei;
        nodec.left = nodef;
        nodec.right = nodeg;
        nodef.left = nodel;
        nodef.right = nodem;

        printNodeK(root, 2);
        System.out.println();
        printNodeK(root, 3);
    }
}
