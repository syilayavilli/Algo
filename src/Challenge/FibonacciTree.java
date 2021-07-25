package Challenge;

//  index 0 1 2 3 4 5 6  7  8  9 ...
//  fib   0 1 1 2 3 5 8 13 21 34 ...
public class FibonacciTree {


    //Number of leaf nodes is 2^n so the Time complexity is O(2^n)
    //O(number of branches ^ depth of the branch) O(2^n)
    //Space complexity will be the depth of the Tree - recursion to hold the
    //variables in stack and gets released once the tree ends to the leaf O(n)
    public static int fibonacci(int n) {

        //Base condition
        if (n <= 1) {
            return n;
        }

        System.out.println("{" + (n-1) + "," + (n-2) + "}");
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main (String[] args) {

        System.out.println("The fibonacci at -2 is " + fibonacci(-2));
        System.out.println("The fibonacci at 0 is " + fibonacci(0));
        System.out.println("The fibonacci at 1 is " + fibonacci(1));
        System.out.println("The fibonacci at 5 is " + fibonacci(5));
    }
}
