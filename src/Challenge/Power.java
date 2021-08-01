package Challenge;

//        Implement a power function to raise a double to an int power, including negative powers.
//        e.g. pow(double d, int p) should give 'd' raised to power 'p'.
//        Of course, please don't use in-built methods like pow(). Idea is to implement that using
//        recursion.
//
//        Solution: http://stackoverflow.com/questions/101439/the-most-efficient-way-to-implement-aninteger-
//        based-power-function-powint-int  (https://www.youtube.com/watch?v=snOaKR2xgZg)
//        Can you do it in O(log n)
//        Suggested time: 10 minutes to do a brute-force and 15 with a trick that optimizes it.

public class Power {


    public static double bruteForcePow(double d, int p) {

        //Base condition
        if (p == 0) return 1;
        if (p == 1) return d;

        if (p < 0) return bruteForcePow(1/d, -p);

        double result = 1;
        for (int i=0; i< p; i++) {
            result *= d;
        }
        return result;
    }

    public static double pow(double d, int p) {

        //Base condition
        if (p == 0) return 1;
        if (p == 1) return d;

        if (p < 0) return pow(1/d, -p);
        double result;
        if (p % 2 == 0)
            result = pow(d*d, p/2);
        else result = d * pow(d*d, p/2);

        return result;

    }

    public static void main (String[] args) {
//        System.out.println("Pow(2, 5)  is " + bruteForcePow(2, 5));
//        System.out.println("Pow(2, -2) is " + bruteForcePow(2, -2));
//        System.out.println("Pow(2, 2147483647) is " + bruteForcePow(2, 2147483647));

        System.out.println("Pow(2, 5)  is " + pow(2, 5));
        System.out.println("Pow(2, -2) is " + pow(2, -2));
        System.out.println("Pow(2, 2147483647) is " + pow(2, 2147483647));

    }

//    The power function has two base cases: n = 0 and n = 1.
//
//    The power function has two recursive calls. Only one of them is made in any given call.
//
//    Let's first consider the case when n is even: In that case, the recursive call is made with n / 2.
//
//    If all calls would use this case, then you half n in each call down until you reach 1. This is indeed log(n) calls (plus 1 for the base case).
//
//    The other case, when n is odd, reduces n only by one. If all calls would end up using this recursive call then the function would be called n times; clearly not logarithmic but linear thus.
//
//    But what happens to an odd number when you subtract one from it? It becomes an even number. Thus the feared linear behaviour mentioned above cannot occur.
//
//    Worst case is: n is odd, thus use second recursive call. Now n is even, thus first recursive call. Now n is odd, this use second, ... and so on down until n is one. In that case every second call reduces n to n / 2. Therefore you need 2 * log(n) calls then (plus one for the base case).
//
//    So yes, this is in O(log(n)). This algorithm is often called binary exponentiation.
}
