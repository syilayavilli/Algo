package Challenge.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Houses with millions say
6  1   2  7    millions
You cant rob the adjacent as it will alert everyone

select 6 + 2 or 1 and move forward
msv = maximum stolen value
Rob (ary[i] + msv(ary, i+2)) or Rob msv(ary, i+1)
max(ary[i] + msv(ary, i+2)  or msv(ary, i+1)
max (max(ary[i] + msv(ary, i+2)  or msv(ary, i+1))
Note: at the last element it can go 2 more beyond last element
Also there is problem repetition when i+2 == i+1

base condition if you reached end of array i.e. beyond array return 0;
if no houses then return zero;

Greedy Algorithms - Here this will not work

 */
public class HouseRobbery {
    public static void main(String[] args) {
        int[] aryHouseValues = {6, 1, 2, 7};

        //System.out.println("Max: " + maxStolenValue(aryHouseValues, 0));
        System.out.println("Maxvalue with DP is : " + maxStolenValueDP(aryHouseValues));
    }

    private static int maxStolenValue(int[] aryHouseValues, int i) {

        //base condition
        if( i >= aryHouseValues.length) { // i == length and  i == length + 1 (2 more)
            return 0;
        }

        return Math.max(aryHouseValues[i] + maxStolenValue(aryHouseValues, i+2), maxStolenValue(aryHouseValues, i+1)  );

    }

    /*
        index  0 1 2 3
        values 6 1 2 7

        dp
        index  0  1  2  3  4   5
        values             0   0

        dp
        index  0  1  2  3  4   5
        values             0   0

     */
    private static int maxStolenValueDP(int[] aryHouseValues) {

        // DP will return integers and the length will be length + 2 here
        int[] dp = new int[aryHouseValues.length + 2]; //space for two base cases
         dp[dp.length-1] = 0; //base condition
         dp[dp.length-2] = 0; //base condition

        //fill it from the back
        //If recursion is done from top to bottom - in dp we will do bottom to top
        //If recursion is done from bottom to top = in dp we will do top to bottom
         for (int i = dp.length-3; i>=0  ; i-- ) {
             //i starts with 3 and we take value of 3 and 3+2 or 4 note: 3+2 and 3 + 1 are zeroes
             //dp
             //index  0  1  2  3  4   5
             //values          7  0   0

             /*

              index  0 1 2 3
              values 6 1 2 7

             //dp
             //index  0  1  2  3  4   5
             //values       7  7  0   0

             //dp max of 8, 7
             //index  0  1  2  3  4   5
             //values    8  7  7  0   0

             //dp max of 8, 7
             //index  0  1  2  3  4   5
             //values 13 8  7  7  0   0

              */

             dp[i] = Math.max(aryHouseValues[i] + dp[i+2], dp[i+1]);
         }
        System.out.println("dp table : " + Arrays.toString(dp));
         return dp[0]; //result will be zero
         //T = o(n)
        //S = 0(n)
        //Note: we can optimize the above by using just three variables instead of the array similar to fibonacci series
        //See DP2 below
    }


    private static int maxStolenValueDP2(int[] aryHouseValues) {
        //complete for HW using constant space

        return -1;
    }
}
