package Challenge.Graphs;
//Number of Islands
//Binary matrix  1- land 0 - water. Find number of islands from this matrix
/*
    0  1 0  1  1
    1  0 0  1  1
    0  0 1  1  1
    0  0 0  0  0
    1  1 1  0  1

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

    if we dont want to hold isVisited due to additional space,
    we can change the inout of 1 is visited to -1 and we can replace back -1 to 1

    3*3 matrix - leaving the node will be 8 directions
    8 statements to travese the direction or an easier way small trick
    small trick is
       either use the above direction trick  or call dfs multiple times i.e. 8 times
       dfs(matrix, row+1, col); //up - add boundary condition
       dfs(matrix, row-1, col); //down - add boundary condition
       dfs(matrix, row-1, col-1); //up left -add boundary condition
        .... 8 statements

        static int[[][] directions = {
            {-1, 0},
            {},

        };

    //Undirectedgrpahdemo and count islands
 */
public class CountIslandBinaryMatrix {
}
