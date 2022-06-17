package Challenge;

public class RecursionPractice {

    public static boolean isPalindrome (String pal) {

        //Base condition
        if (pal.length() == 0)
            return true;

        return isPalinHelper(pal, 0, pal.length()-1);

    }

    public static boolean isPalinHelper(String pal, int start, int end) {

        if (start == end) return true;


        if (pal.toLowerCase().charAt(start) != pal.toLowerCase().charAt(end)) return false;

        if(start < end) return isPalinHelper(pal, ++start, --end);

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Is Palindrome - racecar " + isPalindrome("racecar"));
        System.out.println("Is Palindrome - Racecar " + isPalindrome("Racecar"));
        System.out.println("Is Palindrome - rhotelr " + isPalindrome("rhotelr"));
        System.out.println("Is Palindrome - helloolleh " + isPalindrome("helloolleh"));
        System.out.println("Is Palindrome - hellolleh " + isPalindrome("hellolleh"));
    }
}
