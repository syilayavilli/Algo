package Challenge;

import java.util.Arrays;

public class TwoSumSorted {


    // The Brute Force still uses nested loops
    // The Time Complexity is O(n *n) = O(n^2) Space Complexity is O(1)
    public static int[] BruteForce (int[] nums, int target) {

        for (int i = 0; i< nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};

                //Since the array is sorted. If we find the sum bigger
                //dont proceed. Move to the next
                if (nums[i] + nums[j] > target)
                    break;
            }
        }
        return new int[]{-1, -1};
    }

    // Since the array is sorted, using the start and end inexes traverses the array once
    // so the Time Complexity O(n). Since no Map is used the Space complexity is O(1)
    public static int[] TwoSumPointer(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            if (nums[startIndex] + nums[endIndex] == target)
                return new int[]{startIndex, endIndex};
            else if (nums[startIndex] + nums[endIndex] > target)
                endIndex--;
            else startIndex++;
        }

        //What is the expected behavior? ask
        return new int[] {-1, -1};
    }


    public static void main(String[] args) {
//        int[] result = BruteForce(new int[]{2,7,11,15}, 9);
//        int[] result1 = BruteForce(new int[]{2,2,7,11,15}, 9);
//        int[] result2 = BruteForce(new int[]{}, 9);
//        int[] result3 = BruteForce(new int[]{-4,2,3,13}, 9);
//        int[] result4 = BruteForce(new int[]{1,1,1,1}, 2);

        int[] result = TwoSumPointer(new int[]{2,7,11,15}, 9);
        int[] result1 = TwoSumPointer(new int[]{2,2,7,11,15}, 9);
        int[] result2 = TwoSumPointer(new int[]{}, 9);
        int[] result3 = TwoSumPointer(new int[]{-4,2,3,13}, 9);
        //Note: Since we use the start and end indexes - the answer is [0,3] not [0,1]
        int[] result4 = TwoSumPointer(new int[]{1,1,1,1}, 2);

        System.out.println("The result int[]{2,7,11,15}, target 9 is " + Arrays.toString(result));
        System.out.println("The result int[]{2,2,7,11,15}, target 9 is " + Arrays.toString(result1));
        System.out.println("The result int[]{}, target 9 is " + Arrays.toString(result2));
        System.out.println("The result int[]{-4,2,3,13}, target 9 is " + Arrays.toString(result3));
        System.out.println("The result int[]{1,1,1,1}, target 2 is " + Arrays.toString(result4));
    }
}
