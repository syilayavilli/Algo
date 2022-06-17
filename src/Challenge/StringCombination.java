package Challenge;

import java.util.*;

public class StringCombination {

    public static void main(String[] args) {


        // All possible strings
        String str = "apple";
        str = "cat";
        // n^2 ; but because of substring and print it will be n^3
//        for (int start=0; start < str.length(); start++) {
//            for (int end= start +1 ; end < str.length() + 1; end++) {
//                //we need length + 1 because the substring end is exclusive
//                String subStr = str.substring(start, end);
//                System.out.print(subStr + "|");
//
//            }
//        }

        // we need to get "apple"
        /*
            apple
            a p p le
            a pp l e
            a ppl e
            a pple
            ap p l e
            app l e

         */

        printSubStringSets(str);

        //Hw - check if the word exists in dictionary
        //Put in the list only the valid ones
        //Word Break is the name of the problem or palendromic decomposition

    }

    static void printSubStringSets(String str) {
        List<String> resultList = new ArrayList();
        printSubStringSets(str, 0, resultList);
    }

    static void printSubStringSets(String str, int start, List<String> resultList) {

       if (start == str.length()) {
           //store the result in a list
           System.out.println("Result " + resultList);
           return;
        }

       for (int end = start+1; end < str.length()+1; end++) {
           String subStr = str.substring(start, end);
           resultList.add(subStr);
           printSubStringSets(str, end, resultList);

           //backtrack  - Remove last - try without the below
           resultList.remove(resultList.size() -1);
        }

    }
}
