package Challenge;

// Google states a story about a Maze ... which needs to translated to a matrix

//This could be in any directions with restrictions

//Recursion is brute force - try all possibilities and take the max so Time cmplecity is Exponential
//Optimized solution using DP Time complexity is Linear Time

//Combination permutation --- check this

//Time Complexity - Worst Case branches raised to the depth for a square matrix  2^n
// 2 ^ max(m,n)
// if the direction is 3 ways it will 3^ , if 4 ways it will be 4^
//For Ragged arrays - we will have to check for "row" not "0" and other checks

public class MaxSum2DMatrix {

    public static void main (String[] args) {
        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                         { 1,  0, 0, 30, 2, 5 },
                         { 0, 10, 4,  0, 2, 0 },
                         { 1,  0, 2, 20, 0, 4 }
        };

        int mat2[][] = new int[6][4];

        String [][] example = { {"Please!", "Thanks"},
                                {"Hello!", "Hey", "Hi!"},
                                {"Why?", "Where?", "When?", "Who?"},
                                {"Yes!"}
                                };
        System.out.println("Maximun Sum in a path found is " + maxSumInPath(mat));
    }

    public static int maxSumInPath(int[][] ary) {
        return maxSumInPath(ary, 0, 0);
    }

    public static int maxSumInPath(int[][] ary, int row, int col) {

        //Base Condition

        //Matrix with one element or empty matrix
        //One cell or the last cell
        if (row == ary.length - 1 && col == ary[0].length - 1) {
            return ary[row][col]; //return the same cell - last cell or only cell
        }

        // Base condition 2 - Reached the bottom row of the matrix -
        // Bottom wall check
        if (row == ary.length - 1) {
            // return current value + go to the right
            return ary[row][col] + maxSumInPath(ary, row, col + 1);
        }

        //Base Condition 3: Hit the wall on the right
        //
        if (col == ary[0].length - 1) {
            // return current value + go to the right
            return ary[row][col] + maxSumInPath(ary, row + 1, col);
        }

        //recursive case 4 - somewhere in the middle
        // you can down or right
        //int maxFromDown = ary[row][col] + maxSumInPath(ary, row +1, col);
        //int maxFromRight = ary[row][col] + maxSumInPath(ary, row, col +1);

        //return maxFromDown + maxFromRight;

        //another way
        int maxFromDown = maxSumInPath(ary, row +1, col);
        int maxFromRight = maxSumInPath(ary, row, col +1);

        return ary[row][col] + Math.max(maxFromDown, maxFromRight);

    }
}
