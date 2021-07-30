package Challenge;

public class GroupSum {

    public static void main() {
//        groupSum(0, [2, 4, 8], 10); //→ true
//        groupSum(0, [2, 4, 8], 14); // → true
//        groupSum(0, [2, 4, 8], 9); // → false

        int[] ary = {2, 4, 8};

        System.out.println("{2, 4, 8} target 10 " + groupSum(ary, 10) );
        System.out.println("{2, 4, 8} target 10 " + groupSum(ary, 14) );
        System.out.println("{2, 4, 8} target 10 " + groupSum(ary, 9) );
    }

    public static boolean groupSum(int[] ary, int target) {
        return groupSum(ary, 0, target);
    }

    public static boolean groupSum(int[] ary, int i,  int target) {

        //base condition
        //moving i to the end of the array
        if (i == ary.length) { // we found the solution
            //Add up all the elements and check if the target was reached
            //If target is zero we have reached the soltion

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
