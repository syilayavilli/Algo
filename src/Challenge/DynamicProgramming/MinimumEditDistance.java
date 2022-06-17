package Challenge.DynamicProgramming;

import java.util.Arrays;

/*
Levenshtein distance - Wikipedia

https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-fuzzy-query.html
Used in elastic searches
Spell checkers

str1 = apple
str2 = app
           str1    str2
            /  \   \

     Ins       Replace       Delete
     /\\         /\\         /\\
   I  R  D       I R D       I R D

In Every Step we have to take 3 decisions
T = O( number of branches ^n) where n is the length of the shortest string
T = O(3^(max(s1,s2)))  ex: s1 = "banana" and s2 = "" - 6 operations

How is this a DP problem

s1 = "red"
s2 = "bet"
Minimum edit distance is 2  i.e. 2 operations replace r with d and replace d as t
DP - do not have to repeat the conversion
       s1 s2
      (0, 0)
      /  |  \


        s1, S2
        (3, 3)

        3,2                     2,2   2, 3

        3,1           2,1   2,2

        3,0  2,0  2,1
                  2,0  1,0          1,1
                       0,0          1,0

so we can see we have repeating index values this is why this is a dp problem



 */
public class MinimumEditDistance {

    public static void main(String[] args) {
        String str1 = "red";
        String str2 = "bet";

        int minDist = minDist(str1, str2);
        System.out.println("minDist : " + minDist);
    }

    private static int minDist(String str1, String str2) {
        return minDist(str1, str2, str1.length(), str2.length());
    }

    private static int minDist(String str1, String str2, int s1, int s2) {

        //Base Condition
        //either of string becomes zero
        if (s1 == 0 ) {
          return s2;   //not str1.length()  or str2.length()
        }
        if(s2 == 0) {
            return s1; //not str2.length() or str1.length()
        }


        //no operation - Since we pass .length() we need to be sure to use (s-1)
        //Using .length() helps the DP translation else we will have index out of bounds
        // and handling boundary condition will be mess and mapping to DP can become difficult
        //so use input as .length()
        if (str1.charAt(s1-1) == str2.charAt(s2-1)) {
            return minDist(str1, str2, s1-1 , s2-1);
        }

        //operation -- 3 ; chars are not equal
        return 1 + min(   // 1 for the current operation and is needed to count the number of operations (min from insert, replace or delete)
        minDist(str1, str2, s1 , s2-1),   //Insert
        minDist(str1, str2, s1-1 , s2-1),   //Replace
        minDist(str1, str2, s1-1 , s2)   //Delete
        );

    }

    private static int min(int x, int y, int z) {
        //this can be implemented later in interview
        //Math.min(Math.min(x,y), z);  ... check GitHub

        //if (x < y)
        return 1;
    }

 /*
   dp table will 2 dimention one for str1 and one for str2
   str1 = "red" str2 = "bet"
   length str1.length() + 1 and str2.length() +1
  s1  s2->  0   1   2   3
     0      0   1   2   3
     1      1
     2      2
     3      3

  s1 = 1
  s2 = 1
 s1  s2->   0   1       2     3
     0      0   1       2     3
     1      1   (1+0)  (1+1) (1+2)
     2      2   (1+1)  (1)   (1+1)
     3      3   (1+2)  (1+1) (1+1)

  */

    private static int minDistDP(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        //if s1 = 0
        for(int i=0; i<dp.length; i++) {
            dp[0][i] = i;
        }

        //if s2 ==0
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = i;
        }


        for(int s1=1; s1<dp.length; s1++) {
            for(int s2=1; s2<dp[0].length; s2++) {
                if(str1.charAt(s1-1) == str2.charAt(s2-1)) {
                    dp[s1][s2] = dp[s1-1][s2-1];
                } else {
                    dp[s1][s2] = 1 + min(dp[s1][s2-1], dp[s1-1][s2-1], dp[s1-1][s2]);
                }
            }
        }
       for (int[] ary : dp) {
           System.out.println(Arrays.toString(ary));
       }
        //look at the recursion solution to
        return dp[str1.length()][str2.length()]; //dp[dp.length-1][dp[0].length-1]

    }


}
