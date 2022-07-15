package Challenge.Graphs;

import java.util.HashSet;
import java.util.Set;

/*
LeetCode 694 Number of distinct islands
This is a variation to the number of Islands problem

We can do with DFS, similar to Connected components, in place of incrementing count
we need to add unique StringBuffer in a HashSet (distinct)
The String buffer will include all the island's relative coordinates for x and y from first island
So we will define member variables baseRow and baseCol
After every connected island we should reset the StringBuffer
 */
public class CountDistinctIslandBinaryMatrix {

    static int baseRow; //we need this to calculate the relative x position of other cell
    static int baseCol; //we need this to calculate the relative y position of other cell
    static int[][] direction = {
            {-1, 0}, //up
            {1,0}, //down
            {0, -1}, //left
            {0, 1}, //right
            {-1, -1}, //up left
            {1,1}, //down right
            {1,-1}, //down left
            {-1,1} //up right
    };

    static int CountDistinctIslands(int[][] matrix) {
        Set<String>  islandShapes = new HashSet<String>();
        //Loop through each of the matrix cell

        for (int row=0; row<matrix.length; row++) {
            for(int col= 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    baseRow = row;
                    baseCol = col;
                    StringBuffer islandSB = new StringBuffer();
                    dfs(matrix, row, col, islandSB);
                    islandShapes.add(islandSB.toString());
                }

            }
        }
        return islandShapes.size();
    }

    static void dfs(int[][] matrix, int row, int col, StringBuffer islandSB) {
        //we are not using isVisited instead we will set the column with 1 to -1
        matrix[row][col] = -1;

        //process the island cell
        islandSB.append((row - baseRow) + "," + (col - baseCol));

        //For each the cell traverse by DFS all eight direction
        for (int[] d : direction) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (isValid(matrix, newRow, newCol) &&  matrix[newRow][newCol] == 1) {
                dfs(matrix, newRow, newCol, islandSB);
            }
        }
    }

    static boolean isValid(int[][] matrix, int r, int c) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,1,0,0,0},
//                {0,1,0,0,1},
//                {1,0,0,1,1},
//                {0,0,0,0,0},
//                {1,0,1,0,1}
//        };
//        System.out.println(" Number of Distinct Islands is " + CountDistinctIslands(matrix)); //3

        int[][] matrix = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(" Number of Distinct Islands is " + CountDistinctIslands(matrix)); //1
    }

}
