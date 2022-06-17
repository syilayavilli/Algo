package Challenge.Recursion;
// This is Word Break 2 problem - there is word break 1 and word break 3



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
//
//        Note:
//
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//
//        Input:
//        s = "catsanddog"
//        wordDict = ["cat", "cats", "and", "sand", "dog"]
//        Output:
//        [
//        "cats and dog",
//        "cat sand dog"
//        ]
//        Example 2:
//
//        Input:
//        s = "pineapplepenapple"
//        wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//        Output:
//        [
//        "pine apple pen apple",
//        "pineapple pen apple",
//        "pine applepen apple"
//        ]
//        Explanation: Note that you are allowed to reuse a dictionary word.
//        Example 3:
//
//        Input:
//        s = "catsandog"
//        wordDict = ["cats", "dog", "sand", "and", "cat"]
//        Output:
//        []
public class WordBreak21 {

    public static void main (String[] args) {
        String input = "catsanddog";
        input = "cats";
        List<String> dictionary = new ArrayList(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        wordBreak(input, input.length(), dictionary);

    }

    public static void wordBreak(String input, int strLen, List<String> dict) {
        String output = "";
        wordBreak_helper(input, strLen, output, dict);

    }

    public static void wordBreak_helper(String input, int strLen, String output, List<String> dict) {

            //go over the input character by character to see if the word exists in dictionary
            for (int i = 0; i < strLen; i++){
                String word = input.substring(0, i);
                if (dict.contains(word)){
                    //found a match
                    output += word + " ";
                    //Check if we are at the end of the input string
                    if (i == (strLen-1)) {
                        System.out.println(output);
                        return;
                    }

                    //else continue with the remaining characters in the string
                    wordBreak_helper(input.substring(i, strLen-1), ((strLen-1)-i), output, dict);
                }
            }
    }

}
