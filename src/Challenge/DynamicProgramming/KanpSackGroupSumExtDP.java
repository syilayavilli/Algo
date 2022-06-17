package Challenge.DynamicProgramming;

import java.util.Arrays;

/*
This one is knapsack 0/1 problem (others are knapsack bounded and unbounded)

have a backpack/Knapsack - weight limitit can carry. Variou item of different weights and values
Soldier has a knapsack bag and there is limit of item they can carry. Max items they can carry not exceeding 100 lbs
and max value

       w1   w2  w3  w4  w5  w6  < 100
weight 20   40  10  25  15  5
Value  10   5   60  40  50  90
Pick it or dont pick it , one variation is you not only test one criteria but two attributes added.


Best Value ->

Bounded - You can pick an item x number of time
UnBounded - You can pick an item any number of times

Solution is Powerset problem - Select and not select target being 100 lbs

recursively - Brute force way

         knapsack
           / \
          /\  /\
       selected not selected

 For DP we will use 2 dimension array
 For each set get Max value

 The Recursion is o(2^n) exponential the DP is pseudo Polynomial o(nWeight) and when the number of itms is large - the time complexity will be large
 dp[i-1][] (i-1 is the row minus 1
 */
public class KanpSackGroupSumExtDP {

    public static void main (String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 30; //Answer should max value 160

        System.out.println("knapsack: " + knapsack(val, wt, W));
    }

    /*
    index  0    1   2
       wt  60  100  120
       val 10  20   30
       <------------- index moves from right to left
     */
    private static int knapsack(int[] val, int[] wt, int W) {

        //Top left to top right - for this problem
        //Group Sum DP goes from bottom left to top right

        return knapsack(val, wt, wt.length,  W);
    }

    /*
        see index starts with length 3 decreasing
        index 0  1  2
              10 20 30

                 KS(3, 30) Start here
          KS(2,  0)     KS (2, 30)
            select     don't select


     */
    private static int knapsack(int[] val, int[] wt, int i, int W) {

        //base condition as index moves from 2 to 0
        if (i == 0) {
            return 0;
        }
        //base condition for Weight as well
        //when target weight W becomes 0 or if function is called with W=0
        //Some weight can make W negative so if(W ==0) will not work
        //if (W == 0) {
        if (W == 0) { // we cant allow negative to pass through
            return 0;
        }

        // We subtract so the resultant W is good to become zero
        // if weight W becomes negative - take care now
        //cause W can become negative - so we should not let it go negative
        if (wt[i-1] > W) {
            return knapsack(val, wt, i-1, W);
        } else {


            //W-wt[i-1]

            //Select also we will take the value
            // not i starts at high number
            //knapsack(val, wt, i-1, W - wt[i-1]);
            // val[i-1] + knapsack(val, wt, i-1, W - wt[i-1]);
            //We don't select
            //knapsack(val, wt, i-1, W);

            //Since we want to take max value
            //Return the maximum of two cases
            // case 1 : nth item included
            // case 2 : not included

            return
                    Math.max(val[i - 1] + knapsack(val, wt, i - 1, W - wt[i - 1]),

                            knapsack(val, wt, i - 1, W));
        }

        //T = O(2^n)

    }

    /*
    DP solution
    2 dimension matrix DP table
    X Axis knapsack wt     0    1   2   3   4   5
    Y axis ln of array0    0    0   0   0    0
                  1   0
                  2   0
                  3   0
    We are going from top left to bottom right. Solution will be last column last row
    We can go any ways


     */

    private static int knapsackDP(int[] val, int[] wt, int W) {
        int[][] dp = new int[wt.length+1][W+1];

        for (int i=0; i<dp.length; i++) { //option for java because array is initilaized to 0 by default
            //base conditions

            dp[i][0] = 0; //base condition
        }
        for (int w=0; w<dp[0].length; w++) {
            dp[0][w] = 0; //base condition
        }

        for (int i = 1 ; i <dp.length; i++ ) {
            for (int ww=1; ww<dp[0].length; ww++) {
                if(wt[i-1] > ww) {
                    dp[i][ww] = dp[i-1][ww];
                } else {
                    dp[i][ww] = Math.max(val[i-1] + dp[i-1][ww-wt[i-1]] , dp[i-1][ww]);
                }
            }
        }
        for (int[] ary : dp){
            System.out.println(" Dp Table: " + Arrays.toString(ary));
        }
        //wt.length and W
        return dp[wt.length][W]; // or return dp[dp.length][dp[o].length]
    }
}
