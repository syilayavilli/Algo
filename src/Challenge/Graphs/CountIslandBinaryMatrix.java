package Challenge.Graphs;

import java.util.LinkedList;

//Number of Islands
//Binary matrix  1 represents land 0 represents water.
// Find number of islands from this matrix
/* This is an undirected graph

    0  1  0  1  1
    1  0  0  1  1
    0  0  1  1  1
    0  0  0  0  0
    1  1  1  0  1

    there are 4 islands

    Identify this as a graph problem
    Find 1 and all the nearest neighbors that are 1 - when you exhaust then
    we have found an island
    Basically finding number of connected components in graph in a
    undirected graph

    I have a social network - how many teams or social groups in a network

    A-B-C-A,  F-G-H, D-E

    Can be done either by DFS or BFS

    We will do DFS

    for(int r = 0; r < ...) {
       for (int c = 0; c< ...)
           matric[r][c]

    boolean [][] isVisited[matrix.length][matrix[0].length];

    matrix[1][2]

    if we don't want to hold isVisited due to additional space,
    we can change the inout of 1 is visited to -1 and we can replace back -1 to 1

    3*3 matrix - leaving the node will be 8 directions
    8 statements to traverse the direction or an easier way
    small trick is
       either use the above direction trick  or call dfs multiple times i.e. 8 times
       dfs(matrix, row+1, col); //up - add boundary condition
       dfs(matrix, row-1, col); //down - add boundary condition
       dfs(matrix, row-1, col-1); //up left -add boundary condition
        .... 8 statements

        static int[[][] directions = {
            {-1, 0}, //up
            {1,0}, //down
            {0, -1}, //left
            {0, 1}, //right
            {-1, -1}, //up left
            {1,1}, //down right
            {1,-1}, //down left
            {1,1} //down right
        };

    //Undirected graph demo and count islands
 */
public class CountIslandBinaryMatrix {

    //pair fo row and column
    //first element is row, second element is column
    static int[][] directions = {
        {-1, 0}, //up
        {1,0}, //down
        {0, -1}, //left
        {0, 1}, //right
        {-1, -1}, //up left
        {1,1}, //down right
        {1,-1}, //down left
        {-1,1} //down right
    };

    public static void main(String args[]) {

        int[][] matrix = {
                {1,1,0,0,0},
                {0,1,0,0,1},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {1,0,1,0,1}
        };
        System.out.println(" Number of Islands is " + countIslands(matrix));
    }

    public static int countIslands(int[][] matrix) {
        int count = 0;

        //We need to traverse all of the matrix - so we will use double for loop
        for (int row = 0; row < matrix.length; row++) { //for each node/vertex in the graph
            for (int col = 0; col < matrix[0].length; col++) {
                //If the cell is 1 and not visited traverse
                if (matrix[row][col] == 1) { //1 also means a vertex in this problem
                    dfs(matrix, row, col);
                    count++; //count number of connected components
                    //note here we are not using isVisited just to save some space, Check how space is saved
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] matrix, int row, int col) {
        //work as visited by marking 1 to -1
        matrix[row][col] = -1;

        // every cell needs to check its neighbors deep using dfs
        //and there are eight neighbors for each cell. So traverse all
        for (int dir= 0; dir<directions.length; dir++) {

            int newRow = row + directions[dir][0]; //0 cell is row and 1 cell is col
            int newCol = col + directions[dir][1];

            if (isValid(matrix, newRow, newCol) && (matrix[newRow][newCol] == 1)){
                //do dfs
                dfs(matrix, newRow, newCol);
            }
        }

    }

    public static boolean isValid(int[][] matrix, int r, int c) {
        if (r < 0  || r >= matrix.length || c < 0 || c >= matrix[0].length) {
            return false;
        }
        return true;
    }
}
