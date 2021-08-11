package Challenge.Trees;

//Print all Nodes at Level K from the root

// Solution 1 - DFS without using stack
// Solution 2 - DFS using stack - Why do we need to use stack?

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
