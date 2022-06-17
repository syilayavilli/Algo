package Challenge.DynamicProgramming;

import java.util.Arrays;

/*
child can take one step or 2 steps and in how many ways
the child can reach the top of the stairs

 */
public class CountStairsNumWaysToCountStairs {
    public static void main(String[] args) {
        int stairs = 5;


        System.out.println("no of ways: " + countNoOfWays(stairs));

        System.out.println("no of ways: " + countNoOfWaysDP(stairs));
    }
    private static int countNoOfWays(int stairs){

        //base case
        if (stairs == 0) {
            return 1;
        }
        if (stairs < 0 ) {
            return 0;
        }

        //Stairs will decrease by 1 or 2
        return countNoOfWays(stairs -1) + countNoOfWays(stairs - 2);
        //Answers there should be 8 ways
        //T = o(2^n)


    }

    /*
        index 0 1 2 3 4 5
        DP solution will be in the end bottom to top as in recursion we are going bottom to top
        index 0 1 2 3 4 5
        val   1 1 2 3 5 8
     */
    private static int countNoOfWaysDP(int stairs) {
        int[] dp = new int[stairs+1];//solution will be in the last element plus 1

        //Base condition
        //index 0 1 2 3 4 5 -> solution will be on 5
        dp[0] = 1;
        dp[1] = 1;

        for (int st=2; st<dp.length; st++) {
            dp[st] = dp[st-1] + dp[st-2];
        }
        System.out.println("Dp table: " + Arrays.toString(dp));
        return dp[stairs]; //last element

        //T = o(n)
        //S = o(n) -- can be optimozed this? yes with 2 variables

        //Another variable where steps is dynamic for given  int[] steps = {1,2, ...}
        //T = o(m*n) or o(stairs * steps.length)
        //S = o(m*n) or (stairs*steps.length) - double dimesnion array, can we do this in constant space? no because steps is unknown
        //
    }
}
