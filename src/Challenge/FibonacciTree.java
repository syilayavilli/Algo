package Challenge;

//    The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
//    The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value
//    is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
//    Define a recursive fibonacci(n)
//    method that returns the nth fibonacci number, with n=0 representing the start of the sequence.


//  index 0 1 2 3 4 5 6  7  8  9 ...
//  fib   0 1 1 2 3 5 8 13 21 34 ...
public class FibonacciTree {


    //Number of leaf nodes is 2^n so the Time complexity is O(2^n)
    //O(number of branches ^ depth of the branch) O(2^n)
    //Space complexity will be the depth of the Tree - recursion to hold the
    //variables in stack and gets released once the tree ends to the leaf O(n)
    //See derivation of 2^n in https://syedtousifahmed.medium.com/fibonacci-iterative-vs-recursive-5182d7783055
    //https://medium.com/@danfcorreia/fibonacci-iterative-28b042a3eec
    public static int fibonacci(int n) {

        //Base condition
        if (n <= 1) {
            return n;
        }

        System.out.println("{" + (n-1) + "," + (n-2) + "}");
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //https://medium.com/@danfcorreia/fibonacci-iterative-28b042a3eec
    public static int fibonacciIterative(int n) {

            //Create an array of n
            int[] sequence = new int[n];
            sequence[0] = 0;
            sequence[1] = 1;

            for (int i =2; i <= (n-1); i++) {
                sequence[i] = (i-1) + (i - 2);
            }

            return sequence[n-1];

    }

    public static void main (String[] args) {

//        System.out.println("The fibonacci at -2 is " + fibonacci(-2));
//        System.out.println("The fibonacci at 0 is " + fibonacci(0));
//        System.out.println("The fibonacci at 1 is " + fibonacci(1));
//        System.out.println("The fibonacci at 5 is " + fibonacci(5));
        System.out.println("The fibonacci iterative at 5 is " + fibonacciIterative(5));
    }

//                     5 r(5)
//            r(3)4         3 r(2)
//          r(2)3   2r(1)
//       r(1)2    1 r(1)
//    r(1) 1   0 r(0)
//    Note r(n) returns value n


}
