package Challenge.Recursion;

//https://codingbat.com/java/Recursion-1

public class CodingBat1 {

//    Given n of 1 or more, return the factorial of n,
//    which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
   public static int factorial(int n) {

       // Base case: if n is 1, we can return the answer directly
       if (n == 1)
           return 1;

       // Recursion: otherwise make a recursive call with n-1
       // (towards the base case), i.e. call factorial(n-1).
       // Assume the recursive call works correctly, and fix up
       // what it returns to make our result.
       return n *  factorial(n-1);
   }

//    We have a number of bunnies and each bunny has two big floppy ears.
//    We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
    public static int bunnyEars(int bunnies) {

        //Base condition
        if (bunnies == 0)
            return 0;

        //Each bunny has 2 ears , so sum up
        return 2 + bunnyEars(bunnies-1);
    }

//    The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
//    The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value
//    is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
//    Define a recursive fibonacci(n)
//    method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
    public static int fibonacci(int n) {

        if ( n <= 1)
            return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }

//    We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
//    The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
//    Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
//
//
//    bunnyEars2(0) → 0
//    bunnyEars2(1) → 2
//    bunnyEars2(2) → 5
    public static int bunnyEars2(int bunnies) {

       //base condition
        if (bunnies == 0) {
            return 0;
        }

        if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        } else {
            return 2 + bunnyEars2(bunnies -1);
        }
   }

//    We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks,
//    the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication)
//    the total number of blocks in such a triangle with the given number of rows.
//
//
//    triangle(0) → 0
//    triangle(1) → 1
//    triangle(2) → 3
    public int triangle(int rows) {
        //Base condition
        if (rows == 0) {
            return 0;
        }

        return rows + triangle(rows -1);
    }

//    Given a non-negative int n, return the sum of its digits recursively (no loops).
//    Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
//    while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
//
//
//    sumDigits(126) → 9
//    sumDigits(49) → 13
//    sumDigits(12) → 3
    public int sumDigits(int n) {

    //base condition 6 + 2 + 1
    if (n < 10) {
        return n;
    }

    return (n % 10) + sumDigits(n/10);
}

//    Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops).
//    Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
//    while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
//
//
//    count7(717) → 2
//    count7(7) → 1
//    count7(123) → 0
    public int count7(int n) {

        if (n < 10 && n == 7) {
            return 1;
        }
        if (n < 10 && n != 7) {
            return 0;
        }
        int x = n % 10;

        if ( x == 7) {
            return 1 + count7(n/10);
        }
        return count7(n/10);
    }

//    Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
//    except that an 8 with another 8 immediately to its left counts double,
//    so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
//    while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
//
//
//    count8(8) → 1
//    count8(818) → 2
//    count8(8818) → 4
    public int count8(int n) {

    //base condition
    if (n < 10) {
        return (n == 8) ? 1 : 0;
    }

    if (n % 10 == 8) {
        //check if the next chanracter is also an 8
        if ((n/10) % 10 == 8) {
            return 2 + count8(n/10 );
        }
        else {
            return 1 + count8(n/10);
        }
    }
    return count8(n/10);

}

//    Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power,
//    so powerN(3, 2) is 9 (3 squared).
//
//
//    powerN(3, 1) → 3
//    powerN(3, 2) → 9
//    powerN(3, 3) → 27
    public int powerN(int base, int n) {

        //base condition
        if (n == 0) return 1;

        return base * powerN(base, n-1);

    }

//    Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
//
//
//    countX("xxhixx") → 4
//    countX("xhixhix") → 3
//    countX("hi") → 0
    public int countX(String str) {

        if (str.length() == 0) {
            return 0;
        }

        if (str.charAt(0) == 'x') {
            return 1 + countX(str.substring(1));
        }
        return countX(str.substring(1));
    }

//    Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
//
//
//    countHi("xxhixx") → 1
//    countHi("xhixhix") → 2
//    countHi("hi") → 1
    public int countHi(String str) {

        if (str.length() < 2) {
            return 0;
        }

        if (str.charAt(0) == 'h' ) {
            if (str.charAt(1) == 'i') {
                return 1 + countHi(str.substring(2));
            }
        }
        return countHi(str.substring(1));
    }

//    Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
//
//
//            changeXY("codex") → "codey"
//    changeXY("xxhixx") → "yyhiyy"
//    changeXY("xhixhix") → "yhiyhiy"
    public String changeXY(String str) {

        if (str.length() == 0){
            return str;
        }
        char ch = str.charAt(0);
        if (ch =='x') {
            return 'y' + changeXY(str.substring(1));
        }
        return ch + changeXY(str.substring(1));
    }

//    Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
//
//
//    changePi("xpix") → "x3.14x"
//    changePi("pipi") → "3.143.14"
//    changePi("pip") → "3.14p"

    public String changePi(String str) {

        //base condition
        if (str.length() < 2)
        {
            return str;
        }

        String left = str.substring(0,2);

        if (left.equals("pi")) {
            return "3.14" + changePi(str.substring(2));
        }
        return str.charAt(0) + changePi(str.substring(1));

    }

//    Given a string, compute recursively a new string where all the 'x' chars have been removed.
//
//
//    noX("xaxb") → "ab"
//    noX("abc") → "abc"
//    noX("xx") → ""
       public String noX(String str) {

                //base condition
                if (str.length() == 0) {
                    return str;
                }
                char ch = str.charAt(0);
                if (ch == 'x') {
                    return noX(str.substring(1));
                }
                return ch + noX(str.substring(1));
       }

//    Given an array of ints, compute recursively if the array contains a 6.
//    We'll use the convention of considering only the part of the array that begins at the given index.
//    In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
//
//    array6([1, 6, 4], 0) → true
//    array6([1, 4], 0) → false
//    array6([6], 0) → true
    public boolean array6(int[] nums, int index) {

        //base condition
        if (nums.length == index) {
            return false;
        }

        if (nums[index] == 6) {
            return true;
        }
        return array6(nums, index+1);
    }

//    Given an array of ints, compute recursively the number of times that the value 11 appears in the array.
//    We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
//
//
//    array11([1, 2, 11], 0) → 1
//    array11([11, 11], 0) → 2
//    array11([1, 2, 3, 4], 0) → 0

    public int array11(int[] nums, int index) {
        //base condition
        if(index == nums.length) {
            return 0;
        }

        if (nums[index] == 11) {
            return 1 + array11(nums, index+1) ;
        }
        return array11(nums, index+1);

    }

//    Given an array of ints, compute recursively if the array contains somewhere a value followed
//    in the array by that value times 10.
//    We'll use the convention of considering only the part of the array that begins at the given index.
//    In this way, a recursive call can pass index+1 to move down the array.
//    The initial call will pass in index as 0.
//
//
//    array220([1, 2, 20], 0) → true
//    array220([3, 30], 0) → true
//    array220([3], 0) → false

    public boolean array220(int[] nums, int index) {

        //base condition - Tricky blank condition and boundary condition
        if (nums.length <= index+1) {
            return false;
        }

        if (nums[index + 1] == nums[index] * 10) {
            return true;
        }

        return array220(nums, index+1);
    }

//    Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
//
//
//    allStar("hello") → "h*e*l*l*o"
//    allStar("abc") → "a*b*c"
//    allStar("ab") → "a*b"
    public String allStar(String str) {

        //base condition
        if (str.length() <= 1) {
            return str;
        }

        return str.charAt(0) + "*" + allStar(str.substring(1));
    }

//    Given a string, compute recursively a new string where identical chars that are adjacent
//    in the original string are separated from each other by a "*".
//
//
//    pairStar("hello") → "hel*lo"
//    pairStar("xxyy") → "x*xy*y"
//    pairStar("aaaa") → "a*a*a*a"
    public String pairStar(String str) {

        //base condition
        if (str.length() < 2) {
            return str;
        }
        char ch = str.charAt(0);
        if (ch == str.charAt(1))
        {
            return ch + "*"  + pairStar(str.substring(1));
        }
        return ch + pairStar(str.substring(1));
    }

//    Given a string, compute recursively a new string where all
//    the lowercase 'x' chars have been moved to the end of the string.
//
//
//    endX("xxre") → "rexx"
//    endX("xxhixx") → "hixxxx"
//    endX("xhixhix") → "hihixxx"



//    Given a string, compute recursively the number of times lowercase "hi"
//    appears in the string, however do not count "hi" that have an 'x' immediately before them.
//
//    countHi2("ahixhi") → 1
//    countHi2("ahibhi") → 2
//    countHi2("xhixhi") → 0

    public static int countHi2(String str) {

        if(str.length() < 2)
            return 0;
        if(str.length() == 2)
            return (str.equals("hi")) ? 1 : 0;
        if(str.charAt(0) == 'x')
        {
            if(str.substring(1, 3).equals("hi"))
                return countHi2(str.substring(3));
            return countHi2(str.substring(1));
        }
        if(str.substring(0, 2).equals("hi"))
            return 1 + countHi2(str.substring(2));
        if(str.substring(1, 3).equals("hi"))
            return 1 + countHi2(str.substring(3));
        return countHi2(str.substring(2));
    }
//    Given a string that contains a single pair of parenthesis,
//    compute recursively a new string made of only of the parenthesis
//    and their contents, so "xyz(abc)123" yields "(abc)".
//
//
//    parenBit("xyz(abc)123") → "(abc)"
//    parenBit("x(hello)") → "(hello)"
//    parenBit("(xy)1") → "(xy)"
    public String parenBit(String str) {

        //strategy - to use str length() check for not a '(' at a start and then check not a ')' at the end
        // If starts with '(' then check ! ')' at the end
        // return str
        //
        //x y z ( abc ) 1 2 3
        //(abc)
        //base condition
        int len = str.length();

        if (str.charAt(0) != '(') {
            //( + abc)123
            if (str.charAt(len - 1) != ')') {
                return parenBit(str.substring(1, len-1));
            }
            return parenBit(str.substring(1));
        }

        if(str.charAt(len - 1) != ')') {
            return parenBit(str.substring(0, len-1));
        }
        return str;

        //test conditions
        // blank or null is not part of the question
        //() (x) (x)1
    }
//    Given a string, return true if it is a nesting of zero or more pairs
//    of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars,
//    and then recur on what's inside them.
//
//
//    nestParen("(())") → true
//    nestParen("((()))") → true
//    nestParen("(((x))") → false
    public static boolean nestParen(String str) {
        //(()) (((x))
        //Strategy - we  need to get the length
        //Check for ( or ) one character from each
        //skip a char in the front and one less from the end
        //if length of string is 0 - we are true and good.

        int len = str.length();
        if (len == 0 ) {
            return true;
        }

        if (str.charAt(0) == '(') {
            if (str.charAt(len-1) == ')') {
                return nestParen(str.substring(1, len-1));
            }
        }

        return false;

        //( ( ( x ) ) )

    }

//    Given a string and a non-empty substring sub, compute recursively the
//    number of times that sub appears in the string, without the sub strings overlapping.
//
//
//    strCount("catcowcat", "cat") → 2
//    strCount("catcowcat", "cow") → 1
//    strCount("catcowcat", "dog") → 0

    public int strCount(String str, String sub) {

        //This one is no overalp so after the first find you skip sub length characters

        //base condition
        int subLen = sub.length();

        if (str.length() < subLen)
        {
            return 0;
        }

        if (str.substring(0, subLen).equals(sub)) {
            return 1 + strCount(str.substring(subLen), sub);
        }
        return strCount(str.substring(1), sub);
    }

//    Given a string and a non-empty substring sub, compute recursively if
//    at least n copies of sub appear in the string somewhere, possibly with overlapping.
//    N will be non-negative.
//
//    strCopies("catcowcat", "cat", 2) → true
//    strCopies("catcowcat", "cow", 2) → false
//    strCopies("catcowcat", "cow", 1) → true
public boolean strCopies(String str, String sub, int n) {

    //Strategy is to reduce the count n as we find the sub and move one character at a time
    //when we don't find and when n is zero we have achieved the minimum set
    //Note this one is with overlapping - after the first find, on char is skipped

    //base condition
    if(n == 0) {
        return true;
    }

    int subLen = sub.length();
    if (str.length() < subLen) {
        return false;
    }

    if (str.substring(0, subLen).equals(sub)) {
        return strCopies(str.substring(1), sub, n-1);
    }

    return strCopies(str.substring(1), sub, n);
    //catcowcat cat 2
}

//    Given a string and a non-empty substring sub, compute recursively the
//    largest substring which starts and ends with sub and return its length.
//
//
//    strDist("catcowcat", "cat") → 9
//    strDist("catcowcat", "cow") → 3
//    strDist("cccatcowcatxx", "cat") → 9
    public int strDist(String str, String sub) {

        // Go from the beginning till you find and go from the back till you find
        //When you find return the str length
        //if you dont find in the back decremnet length by 1
        //if you dont find in the beginning skip by 1 from the beginning and one from the end

        int strLen = str.length();
        int subLen = sub.length();

        if (strLen < subLen) {
            return 0;
        }

        if (str.substring(0,subLen).equals(sub))
        {
            if(str.substring(strLen - subLen).equals(sub))
            {
                //we found the str - return length
                return str.length();
            }
            //if not skip 1 from beginning and back
            return strDist(str.substring(0, strLen-1), sub);
        }

        //if not move forward by 1
        return strDist(str.substring(1), sub);
    }

//    Given an array of ints, is it possible to choose a group of some of the ints,
//    such that the group sums to the given target? This is a classic backtracking recursion problem.
//    Once you understand the recursive backtracking strategy in this problem,
//    you can use the same pattern for many problems to search a space of choices. Rather than looking at the
//    whole array, our convention is to consider the part of the array starting at index start and continuing
//    to the end of the array. The caller can specify the whole array simply by passing start as 0.
//    No loops are needed -- the recursive calls progress down the array.
//    groupSum(0, [2, 4, 8], 10) → true
//    groupSum(0, [2, 4, 8], 14) → true
//    groupSum(0, [2, 4, 8], 9) → false
    public static boolean groupSum(int start, int[] nums, int target) {

        //groupsum strategy - select and unselect
        //Why Select un-select - if there is an item you can select or not select in your inclusion combination
        //if there are three numbers {1, 2, 3} you could have 2^3 ways to add them by selecting an item or not
        //T(O) = 2^n and S(O) = depth of the tree to hold in stack

        //base condition
        if (start == nums.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }

        //select
        if (groupSum(start+1, nums, target-nums[start]))
        {
            return true;
        }

        //unselect
        if (groupSum(start+1, nums, target)) {
            return true;
        }

        return false;
    }

//    Given an array of ints, is it possible to choose a group of some of the ints,
//    beginning at the start index, such that the group sums to the given target?
//    However, with the additional constraint that all 6's must be chosen. (No loops needed.)
//
//
//    groupSum6(0, [5, 6, 2], 8) → true
//    groupSum6(0, [5, 6, 2], 9) → false
//    groupSum6(0, [5, 6, 2], 7) → false
    public static boolean groupSum6(int start, int[] nums, int target) {

        //groupSum6 strategy - select and unselect
        //base condition should check incrementing start completes all the elements start == nums.length i.e. starts with 0 and includes 1 more
        //Why Select unselect - if there is an item you can select or not select in your inclusion combination
        //if there are three numbers {1, 2, 3} you could have 2^3 ways to add them by selecting an item or not
        //but the 6 should always be selected and could be true or false
        //T(O) = 2^n and S(O) = depth of the tree to hold in stack

        if (start == nums.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }

        //if 6 select - we should take true or false -
        if (nums[start] == 6) {
            return groupSum6(start+1, nums, target - nums[start]);
        }

        //select - we should take the true
        if (groupSum6(start+1, nums, target - nums[start])) {
            return true;
        }

        //unselect
        //return groupSum6(start+1, nums, target);
        if (groupSum6(start+1, nums, target)) {
            return true;
        }

        return false;
    }

//    Given an array of ints, is it possible to choose a group of some of the ints,
//    such that the group sums to the given target with this additional constraint:
//    If a value in the array is chosen to be in the group, the value immediately following
//    it in the array must not be chosen. (No loops needed.)
//
//    groupNoAdj(0, [2, 5, 10, 4], 12) → true
//    groupNoAdj(0, [2, 5, 10, 4], 14) → false
//    groupNoAdj(0, [2, 5, 10, 4], 7) → false
    public static boolean groupNoAdj(int start, int[] nums, int target) {

        //strategy select and unselect - all the way to the end
        //target should be zero
        //successive select should be skipped
        //Note: the start can be over the nums.length due to start + 2

        //base condition
        if (start >= nums.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }

        //select and skip the adjacent
        if (groupNoAdj(start+2, nums, target - nums[start])) {
            return true;
        }

        //unselect one at a time
        if (groupNoAdj(start+1, nums, target)) {
            return true;
        }
        return false;
    }

//    Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to
//    the given target with these additional constraints: all multiples of 5 in the array must be included in the group.
//    If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
//
//    groupSum5(0, [2, 5, 10, 4], 19) → true
//    groupSum5(0, [2, 5, 10, 4], 17) → true
//    groupSum5(0, [2, 5, 10, 4], 12) → false

    public boolean groupSum5(int start, int[] nums, int target) {

        //strategy select and unselect - all the way to the end
        //target should be zero
        if (start >= nums.length) {
            return (target == 0);
        }

        if (nums[start] % 5 == 0) {
            //if the next number is 1 (again if start is not the last number) do not include
            if (start < nums.length - 1 && nums[start + 1] == 1)
            {
                return groupSum5(start+2, nums, target - nums[start]);
            }
            return groupSum5(start+1, nums, target - nums[start]);
        }

        //select
        if (groupSum5(start+1, nums, target - nums[start])) {
            return true;
        }

        //unselect
        if (groupSum5(start+1, nums, target)) {
            return true;
        }

        return false;
    }

//    Given an array of ints, is it possible to choose a group of some of the ints,
//    such that the group sums to the given target, with this additional constraint:
//        if there are numbers in the array that are adjacent and the identical value,
//    they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2},
//    either all three 2's in the middle must be chosen or not, all as a group. (one loop can be used to find
//    the extent of the identical values).
//
//    groupSumClump(0, [2, 4, 8], 10) → true
//    groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
//    groupSumClump(0, [2, 4, 4, 8], 14) → false
    public boolean groupSumClump(int start, int[] nums, int target) {

        //strategy select and unselect - all the way to the end
        //target should be zero
        //base condition
        if (start >= nums.length) {
            return (target == 0);
        }

        //need to get the number of time a number repeats itself in consecutive fashion
        int i = start + 1;
        for(; i < nums.length && nums[start] == nums[i]; i++){
        }

        //select - multiply the number of the time the number repeated
        if (groupSumClump(i, nums, (target - ((i-start) * nums[start]))  )) {
            return true;
        }

        if ( groupSumClump(i, nums, target)) {
            return true;
        }

        return false;
    }

//    Given an array of ints, is it possible to divide the ints into two groups,
//    so that the sums of the two groups are the same. Every int must be in one group or the other.
//    Write a recursive helper method that takes whatever arguments you like, and make the initial call
//    to your recursive helper from splitArray(). (No loops needed.)
//
//    splitArray([2, 2]) → true
//    splitArray([2, 3]) → false
//    splitArray([5, 2, 3]) → true

//    public boolean splitArray(int[] nums) {
//        int index = 0;
//        int a = 0;
//        int b = 0;
//        return recurse(index,  a,  b, nums);
//    }
//
//    //Two buckets solution and comapre the buckets
//    public boolean recurse(int index, int a, int b, int[] nums) {
//
//        //Strategy is select to a bucket and not select to a bucket
//        //Once you reach to the end you back track
//        //base condition
//        if (index == nums.length) {
//            return (a == b);
//        }
//
//        if (recurse(index+1, a + nums[index], b, nums)) {
//            return true;
//        }
//
//        if (recurse(index+1, a, b + nums[index], nums)) {
//            return true;
//        }
//        return false;
//
//    }

    // Single balance - add up on one side and subtract on another side
    //so the balance is zero
    public boolean splitArray(int[] nums) {
        int index = 0;
        int balance = 0;
        return recurse(index, balance, nums);
    }

    public boolean recurse(int index, int balance, int[] nums) {

        //Strategy is select to a balance or not select to a balanace
        //Once you reach to the end you back track
        //base condition
        if (index == nums.length) {
            return (balance == 0);
        }

        if (recurse(index+1, balance + nums[index], nums)) {
            return true;
        }

        if (recurse(index+1, balance - nums[index], nums)) {
            return true;
        }
        return false;

    }

//    Given an array of ints, is it possible to divide the ints into two groups,
//    so that the sum of one group is a multiple of 10, and the sum of the other group is odd.
//    Every int must be in one group or the other. Write a recursive helper method
//    that takes whatever arguments you like, and make the initial call to your recursive
//    helper from splitOdd10(). (No loops needed.)
//
//
//    splitOdd10([5, 5, 5]) → true
//    splitOdd10([5, 5, 6]) → false
//    splitOdd10([5, 5, 6, 1]) → true
    public boolean splitOdd10(int[] nums) {

        int a = 0;
        int b = 0;
        int index = 0;
        return recursesplitOdd10(index, a, b, nums);
    }

    public boolean recursesplitOdd10(int index, int a, int b, int[] nums) {

        // Strategy is to use and not use as we backtrack
        // When all elements are scanned check to see if in any path of 2^n is the one side a
        // is multiple of 10 and the other is odd - this would be the base condition

        //base condition
        if (index == nums.length) {
            //sum is multiple of 10, or odd - Either of the buckets could have the one or the other

            return ((a % 10 == 0 && b % 2 == 1) || (b % 10 == 0 && a % 2 == 1));
        }

        if (recursesplitOdd10(index + 1, a + nums[index], b, nums)) {
            return true;
        }

        if (recursesplitOdd10(index + 1, a , b + nums[index], nums)) {
            return true;
        }

        return false;
    }

//    Given an array of ints, is it possible to divide the ints into two groups,
//    so that the sum of the two groups is the same, with these constraints:
//    all the values that are multiple of 5 must be in one group, and all the values that are
//    a multiple of 3 (and not a multiple of 5) must be in the other. (No loops needed.)
//
//    split53([1, 1]) → true
//    split53([1, 1, 1]) → false
//    split53([2, 4, 2]) → true

    public boolean split53(int[] nums) {

        int index = 0;
        int balance = 0;
        return recursesplit53(index, balance, nums);
    }

    public boolean recursesplit53(int index, int balance, int[] nums) {

        //strategy - since we nned to match the two buckets - we could use the same balance
        //check if balance == 0 when we have reached at the end oof the index

        if (index == nums.length) {
            return (balance == 0);
        }


        if (nums[index]%5 == 0) {
            return recursesplit53(index+1, balance + nums[index], nums);
        }

        if (nums[index] % 3 == 0) {
            return recursesplit53(index+1, balance - nums[index], nums);
        }

        if (recursesplit53(index+1, balance + nums[index], nums)) {
            return true;
        }

        if (recursesplit53(index+1, balance - nums[index], nums)) {
            return true;
        }

        return false;
    }



    public static void main (String args[]) {

//       System.out.println(factorial(3));
         //System.out.println(factorial(5));
//
//       System.out.println(bunnyEars(3));
//       System.out.println(bunnyEars(5));

//       System.out.println(fibonacci(1));

         //System.out.println(countHi2("ahi"));

         //System.out.println(nestParen("(())"));

         //System.out.println(strCopies("iiijjj", "ii", 2));

        //int num[] = {5, 6, 2};
        //System.out.println(groupSum6(0, num, 11)); // → true
        //System.out.println(groupSum(0, num, 8)); // → true
        //int num[] = {2, 5, 10, 4};
        //System.out.println(groupNoAdj(0, num, 12)); // → true


    }
}
