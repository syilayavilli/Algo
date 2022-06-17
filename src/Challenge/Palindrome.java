package Challenge;

//Note: String are immutable in Java. For Large string this will cause problems
//Use non-mutable data structure like String Buffer or use the same string and use pointers
// String are thread safe and secure
//This class has the implementation to use only one string and also with pointers

//Note: Using String s1 = "Hello World" and String s2 = "Hello World" - Java uses a process called "Interning"
//String Literals are interned, however String object created with a "new" will be a separate pointer.
//VM and the Java compiler optimize memory allocations for String objects via the Java String Pool.
//See https://www.baeldung.com/java-string-immutable and https://www.baeldung.com/java-string-pool

//Note: "Racecar" vs "racecar" - need to use ignorecase

//Note: doStuff(i++) is different from doStuff(++i) when pass by value the post script would not get passed

// Check in to GitHub

public class Palindrome {

    public static boolean isPalindrome (String pal) {

        //Base condition
        if (pal.length() <= 1)
            return true;


        if (pal.charAt(0) == pal.charAt(pal.length() - 1)) {
            isPalindrome(pal.substring(1, (pal.length() - 1)));
            return true;
        }

            return false;
    }


    public static void main (String[] args)
    {
//        System.out.println("isPalindrome(racecar) is " + isPalindrome("racecar"));
//        System.out.println("isPalindrome(Racecar) is " + isPalindrome("Racecar"));
//        System.out.println("isPalindrome(abba) is " + isPalindrome("abba"));
//        System.out.println("isPalindrome(a) is " + isPalindrome("a"));
//        System.out.println("isPalindrome(hello) is " + isPalindrome("hello"));
//        System.out.println("isPalindrome(acbaca) is " + isPalindrome("acbaca"));
//        System.out.println("isPalindrome(ax) is " + isPalindrome("ax"));


        System.out.println("isPalin(racecar) is " + isPalin("racecar"));
        System.out.println("isPalin(Racecar) is " + isPalin("Racecar"));
        System.out.println("isPalin(abba) is " + isPalin("abba"));
        System.out.println("isPalin(a) is " + isPalin("a"));
        System.out.println("isPalin(hello) is " + isPalin("hello"));
        System.out.println("isPalin(acbaca) is " + isPalin("acbaca"));
        System.out.println("isPalin(ax) is " + isPalin("ax"));
    }

    // Problem Interface
    public static boolean isPalin(String pal) {

        //If string is empty return true - palindrome
        if (pal.length() == 0) return true;

        return isPalin_helper(pal, 0, pal.length() - 1);
    }

    //Helper class
    public static boolean isPalin_helper(String pal, int start, int end)
    {
        // Base condition - if there is one character - it is palindrome
        if (start == end) return true;

        //If the first and last character don't match - it is not palindrome
        if (Character.toLowerCase(pal.charAt(start)) != Character.toLowerCase(pal.charAt(end))) return false;

        //if there are more than 2 characters left call the recursion again
        return (start < end) ? isPalin_helper(pal, ++start, --end): true;
    }
}
