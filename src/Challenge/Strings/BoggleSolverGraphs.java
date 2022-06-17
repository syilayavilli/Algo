package Challenge.Strings;
//30 minutes using Trie
//Chec paper notes
//This is combination of Graphs for traversing matrix and Trie for searching


import java.util.HashSet;

public class BoggleSolverGraphs {
    //TL, T, TR, BL,  B, L, BR , R,
     static int[] rows = {-1, -1, -1, 1,  1, 0,  1, 0};
     static int[] cols  = {-1,  0,  1, -1, 0, -1, 1, 1};

     public static void main(String args[]) {

         char[][] boggle =  {
             {'B', 'P', 'E', 'A'},
             {'X', 'R', 'A', 'D'},
             {'Z', 'A', 'Y', 'T'}
         };
        String[] dict ={"BREAD", "XRAY", "MOM", "DAD"};

        boggleSolver(boggle, dict);
     }

     private static void boggleSolver(char[][] board, String[] dict) {

         HashSet<String> set = new HashSet<>();

         for (String word : dict) {
             set.add(word);
         }


         boolean[][] isVisited =  new boolean[board.length][board[0].length];
         StringBuilder strBuilder = new StringBuilder();
         for(int r=0; r < board.length ; r++){
             for(int c=0; c<board[0].length; c++) {
                 dfs(r, c, board, strBuilder, set, isVisited);
             }
         }
     }

     private static void dfs(int r, int c, char[][] board, StringBuilder strBuilder, HashSet<String> set, boolean[][] isVisited) {

         //mark is visited
         isVisited[r][c] = true;
         //dont visit if already visited

         //Note: we have to have another parameter if we have to return the string -- not done in this example

         //process the node
         strBuilder.append(board[r][c]);
         //check if it is a word or not
         if(set.contains(strBuilder.toString())) {
             //print it
             //System.out.println(strBuilder.toString())l
         }


         //dfs on child nodes
         //Eight directions we can go so add eight statements without writing 8 statements
         for(int i=0; i<8; i++) {
             int nextRow = r + rows[i];
             int nextCol = c + cols[i];

             //check for out of bounds
             if (isValid(nextRow, nextCol, board)) {
                 if(!isVisited[nextRow][nextCol])
                 dfs(nextRow, nextCol, board, strBuilder, set, isVisited);
             }
         }

         //When the whole path is over
         strBuilder.deleteCharAt(strBuilder.length() - 1);
         isVisited[r][c] = false ; //backtrack in the next path;
         //usually we dont do this in other graph problems
         //Note: Also we have to back track the string Builder BPX BPR
         //we need back track to remove the last character
      }

     //Note: IsVisited should be unmarked so that the next path picks up not the current path.
    //So we have to backtrack

     private static boolean isValid(int nextRow, int nextCol, char[][] board) {
         if(nextRow < 0 || nextCol <0  || nextRow >= board.length || nextCol >= board[0].length) {
             return false;
         } else {
             return true;
         }

     }

}
