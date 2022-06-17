package Challenge.Trees;

import java.util.ArrayDeque;

/*
      7
     / \
    3   15
       / \
      9   20

      InOrderTraversal  3, 7, 9, 15, 20

 */
public class BSTIterator {

//    private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
//
//    public BSTIterator(TreeNode root) {
//        stack = new ArrayDeque<TreeNode>();
//        while (root != null) {
//            stack.push(root);
//            root = root.left;
//        }
//    }
//
//    public int next() {
//        TreeNode current = stack.pop();
//        if (current.right != null) {
//            TreeNode temp = current.right;
//            while (temp != null) {
//                stack.push(temp);
//                temp = temp.left;
//            }
//        }
//        return current.val;
//    }


//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
}
