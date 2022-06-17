package Challenge;

import java.util.*;

//Leetcode# 17 - Medium
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//Return the answer in any order.
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//Example 1:
//Input: digits =  "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

public class PhoneNumberDigitsToChar {

    //static int[] phoneDigits = {2,3,4};
    static int[] phoneDigits = {2,3};

    static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(1, "");
        map.put(2,"abc");
        map.put(3, "def");
        map.put(4, "ghi");
    }

    public static void main(String[] args) {
        printInChar(phoneDigits);
    }

    static public void printInChar(int[] phoneDigits) {

        String result = "";
        printInChar(phoneDigits, result, 0);
    }
    public static void printInChar(int[] phoneDigits, String result, int i) {


        //base condition if i = digits.length we complete
        if (i == phoneDigits.length) {
            //we found the solution
             System.out.println(result);
             return;
        }

        String chars = map.get(phoneDigits[i]);

        for (int c=0;  c < chars.length(); c++) { // g over "abc", a, b, c
            char ch = chars.charAt(c);

            result += ch; // initially "a", "d",  "j"
            //next we need to add d

            printInChar(phoneDigits, result, i+1);

            result = result.substring(0, result.length()-1); // explicit backtracking

            //below is failing - check
            //printInChar(phoneDigits, result +ch, i+1); //implicit backtracking
        }

        return;

    }



    // Time complexity 3 branches O(4^N) where N is number of digits
    //4 because some digit has 4 characters
    // T = O(3^m * 4^N) where m is the digit mapping to 3 chars
    // N is digit mapping to 4 chars
    // Space Complexity
}
