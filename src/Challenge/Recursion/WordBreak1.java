package Challenge.Recursion;
//https://leetcode.com/problems/word-break/
//https://www.youtube.com/watch?v=LPs6Qo5qlJM
//        Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//        Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//        Example 1:
//        Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//        Example 2:
//        Input: s = "applepenapple", wordDict = ["apple","pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//        Note that you are allowed to reuse a dictionary word.
//
//        Example 3:
//        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//        Output: false

//Recursive - TC - O(N * 2^N), SC - O(N)
//For all single characters may be present in the dictionary
//for n characters in string there could be n partition points
//and each partition point can exist in the dictionary or not, so you have two choices
//so overall for n characters there are 2^n choices and you have to go through th string once
//So T= O(n * 2^n) and Space is O(n) plus hashmap --- check with iqbal bhai

//Dynamic programming it would be
//DP - TC - O(N^3), SC - O(N)


import java.util.*;

public class WordBreak1 {

        private static Map<String, Boolean> map = new HashMap<String, Boolean>();

        public static void main(String[] args) {

            String input = "leetcode";
            List<String> dictionary = new ArrayList(Arrays.asList("leet","code"));
            System.out.println(wordBreak(input, dictionary));

            input = "applepenapple";
            dictionary = new ArrayList(Arrays.asList("apple","pen"));
            System.out.println(wordBreak(input, dictionary));

            input = "catsandog";
            dictionary = new ArrayList(Arrays.asList("cats","dog","sand","and","cat"));
            System.out.println(wordBreak(input, dictionary));
        }

        public static boolean wordBreak(String input, List<String> dict) {

            if (dict.contains(input))
                    return true;
            if (map.containsKey(input))
                return map.get(input);

            for (int i = 1; i <= input.length(); i++) {
                String partition = input.substring(0, i);
                if (dict.contains(partition) && wordBreak(input.substring(i), dict)) {
                    map.put(input, true);
                    return true;
                }
            }
            map.put(input, false);
            return false;
        }

}
