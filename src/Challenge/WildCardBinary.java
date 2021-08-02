package Challenge;
//        Input: 10?
//        Output: 101, 100
//        i.e. ? behaves like a wild-card. There are two possibilities for 10?, when that ? is replaced with
//        either 0 or 1.
//        Input: 1?0?
//        Output: 1000, 1001, 1100, 1101
//        Please write a program that takes given strings as input and produces the suggested output.
//        Suggested time: 20 minutes.

import java.util.Arrays;

public class WildCardBinary {

    public static void main(String [] args) {
        String str = "10?";
        print(str.toCharArray(), 0);

        String str1 = "1?0?";
        print(str1.toCharArray(), 0);

        String str2 = "????";
        print(str2.toCharArray(), 0);

        String str3 = "1111";
        print(str3.toCharArray(), 0);


    }

    public static void print(char[] str, int index) {

        //Base Condition
        if (index == str.length) {
            System.out.println(str);
            return;
        }

        if (str[index] == '?') {

            // replace '?' by '0' and recurse
            str[index] = '0';
            print(str, index+1);

            // replace '?' by '1' and recurse
            str[index] = '1';
            print(str, index+1);

            // NOTE: Need to backtrack as string
            // is passed by reference to the function
            //System.out.println("b index=" + index + " value "  + str[index]);
            str[index] = '?';
            System.out.println("a" +  Arrays.toString(str));

        } else
            print(str, index+1);
    }
}
