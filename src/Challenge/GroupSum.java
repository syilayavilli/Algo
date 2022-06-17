package Challenge;
//Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
//This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem,
//you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array,
//our convention is to consider the part of the array starting at index start and continuing to the end of the array.
//The caller can specify the whole array simply by passing start as 0. No loops are needed --
//the recursive calls progress down the array.

// T= O(2^n) where n is the number of elements in the array
public class GroupSum {

    public static void main(String[] args) {
//        groupSum(0, [2, 4, 8], 10); //→ true
//        groupSum(0, [2, 4, 8], 14); // → true
//        groupSum(0, [2, 4, 8], 9); // → false

        int[] ary = {2, 4, 8};

//        System.out.println("{2, 4, 8} target 10 " + groupSum(ary, 10) );
//        System.out.println("{2, 4, 8} target 14 " + groupSum(ary, 14) );
//        System.out.println("{2, 4, 8} target  9 " + groupSum(ary, 9) );

        System.out.println("groupSum2 {2, 4, 8} target 10 " + groupSum2(ary, 10) );
        //System.out.println("groupSum2 {2, 4, 8} target 14 " + groupSum2(ary, 14) );
        //System.out.println("groupSum2 {2, 4, 8} target  9 " + groupSum2(ary, 9) );
    }

    public static boolean groupSum(int[] ary, int target) {
        return groupSum(ary, 0, target);
    }

    public static boolean groupSum2(int[] ary, int target) {
        return groupSum2(ary, 0, target);
    }

    public static boolean groupSum(int[] ary, int i,  int target) {

        //base condition
        //moving i to the end of the array
        if (i == ary.length) { // we found the solution
            //Add up all the elements and check if the target was reached
            //If target is zero we have reached the solution

            if (target ==0)  {
                return true;
            } else {
             return false;
            }

        }

        //If we found a target then return true
        //groupSum(ary, i+1, target-ary[i]); //select

        if (groupSum(ary, i+1, target-ary[i])) { //select
            return true;
        }


        if (groupSum(ary, i+1, target)) {   //don't select (we don't deduct number)
            return true;
        }

        return false;
    }


    public static boolean groupSum2(int[] ary, int i, int target ) {

        if (i == ary.length) {
            return target == 0;
        }

        return groupSum2(ary,i+1, target-ary[i]) || groupSum2(ary, i+1, target) ;
    }

}
