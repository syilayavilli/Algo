package Challenge.Strings;

import java.util.HashSet;
import java.util.Set;

/*
sub-string and sub-array are similar
ex: hello    ello, ell, hel, lo
    2468     46, 468

sub-sequence
  ex: aczmno
  sub-sequence - char are not consecutov
  cmo, amno, caom is not a sub sequence

Total substring will be n^2 where n is all the characters in the string


Problem "abcadefc"
solution bcadef

brute force
generate all substrings
for each substring find if char repeated
   if repeated not a valid substring
   if not repeated then is valid
Mark if char repeated
For valid ones store the candidate to variable and the max length
if any other valid is more than the max length then store the max one


How do you generate substring
StringDecomposition

for (int start = 0; start < str.length; start++)
  for(int end = start +1; end < str.length + 1; end++) {
     String subString  = str.substr(start, end)
  }
}

the above for loops make n^2 and the substring operation is o(n)
so it is n^3

To optimize
a b c a d e f c
1 1 1
Sliding Window is the solution
window size is also changing
instead of generating all substrings

a b c a d e f c

Ascii array or hash map

Hash Map
a 1
b 1
c 1
a 2 result = abc and max len = 3
shrink on left side




 */
public class LongestStringWithNoRepeatingChar {
    public static void main(String[] args) {
        String str = "abcadefc";

        String longestSubstrNonRepeatedChars = getlongestSubstrNonRepeatedChars(str);
        System.out.println("result: " + longestSubstrNonRepeatedChars);

    }

    private static String getlongestSubstrNonRepeatedChars(String str) {

        //two pointers needed
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        String res = "";
        int max_length = Integer.MIN_VALUE;

        //for loop or while loop
        for(int right = 0; right<str.length(); right++) {
           //hashset - remove the duplicate , if hashmap then we unset 2 back t0 1
            char ch = str.charAt(right);

            //If seen
            if (!charSet.contains(ch)) { // not seen ch; not repeating
                charSet.add(ch);
            } else { // seen ch; ie repeating
              //create new candidate substring only if the new result is greater than the previous one.
                if (right-left > max_length) {
                    res = str.substring(left, right); //endIndex is exclusive
                    // so the right will be in duplicate and substring ending with right will not include
                    max_length = right - left;
                }

               while(left < right && str.charAt(left) != ch) {
                   charSet.remove(ch);
                   left++;
               }
               left++;
            }

        }// end of for loop
        //if rest of the string is a candiadte greater than max length
        if(str.length() - left > max_length) {
            res = str.substring(left, str.length());
        }
        return res;
    }
}
