package Challenge;

//https://blog.devgenius.io/power-set-algorithm-with-recursion-or-bits-cc3ffcfc0daa

public class PowerSet {

    //Try generic object type as well
    public static void printPowerSet(int[] ary) {
        int[] outputAry = new int[ary.length];
        printPowerSet(ary, 0, outputAry, 0);
    }

    //Read will be indexed for the input array and write will be indexed for output array
    //Why Select and Don't Select - is to get all the possible subsets 2^n
    //{1,2} possible solution is 2^2 = 4 -> {1,2}, {1}, {2}, {} <- select and don't select
    public static void printPowerSet(int[] ary, int read, int[] outputAry, int write) {
        //Base Case -Once we reach the end of the input array print
        //Note: it is not ary.length()-1 - It is one after that.
        if (read == ary.length) {
            //Print
            System.out.print("{");
            for (int i = 0; i< write; i++) {
                System.out.print(outputAry[i]);
                System.out.print(",");
            }
            System.out.print("}");
            System.out.println();
            return;
        }

        //Recursive case - Select (Note: understand the difference between ++write, write + 1 and write++. All have repercussions
        outputAry[write] = ary[read];
        printPowerSet(ary, read+1, outputAry, write +1);

        //Recursive case - Don't Select Note: write is kept as is. Previous use of increment would impact here.
        printPowerSet(ary, read+1, outputAry, write);
    }

    //Try generic object type as well
    public static void printPowerSet2(int[] ary) {
        int[] outputAry = new int[ary.length];
        printPowerSet2(ary, 0, outputAry, 0);
    }

    //Deselect followed by Select
    //Read will be indexed for the input array and write will be indexed for output array
    //Why Select and Don't Select - is to get all the possible subsets 2^n
    //{1,2} possible solution is 2^2 = 4 -> {1,2}, {1}, {2}, {} <- select and don't select
    public static void printPowerSet2(int[] ary, int read, int[] outputAry, int write) {
        //Base Case -Once we reach the end of the input array print
        //Note: it is not ary.length()-1 - It is one after that.
        if (read == ary.length) {
            //Print
            System.out.print("{");
            for (int i = 0; i< write; i++) {
                System.out.print(outputAry[i]);
                System.out.print(",");
            }
            System.out.print("}");
            System.out.println();
            return;
        }

        //Recursive case - Don't Select Note: write is kept as is. Previous use of increment would impact here.
        printPowerSet2(ary, read+1, outputAry, write);

        //Recursive case - Select (Note: understand the difference between ++write, write + 1 and write++. All have repercussions
        outputAry[write] = ary[read];
        printPowerSet2(ary, read+1, outputAry, write +1);

    }

    public static void main (String[] args) {
        int[] ary ={4,5,6};
        printPowerSet(ary);
        //printPowerSet2(ary);
    }

}
