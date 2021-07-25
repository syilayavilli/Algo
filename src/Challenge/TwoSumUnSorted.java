package Challenge;

import java.util.HashMap;
import java.util.Map;

/*Given an array of unsorted integers and a number k. Check if there is a pair of integers in the array that sums to K.
  Write an optimized and brute force solution both. Provide the Time and Space complexity of each
  Time: 10-15 mins.
  Follow up: Return a pair of the indices instead of just existence
    https://leetcode.com/problems/two-sum/
  */

import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.Map;

public class TwoSumUnSorted {

        //    Search all possible pairs
        //    So start with a number and search if the remaining  sums to target
        //    Time Complexity O(n^2) Space Complexity 0(1)
        public static int[] BruteForce(int[] nums, int target) {

            //loop accessing all elements with have Time Complexity O(n)
            for (int i=0; i<nums.length; i++) {
                //Nested loop makes the Time complexity O(n * n) = O(n^2)
                for (int j = i+1; j<nums.length; j++) {
                    if (nums[i] + nums[j] == target)
                        return new int[]{i,j};
                }
            }
            //What should be the expected behavior? ask
            return new int[]{-1, -1};
        }

        // Use a data structure that helps lookup a particular item would be faster
        // This we can loop through the array once and do a lookup to find the delta of the target
        // For lookup to possible we could use a Set or a Map. Both has the contains interface,
        // but if you need to return index you will need to use Map (Key value pair)
        // We will use key for numbers and value of array index
        // Time complexity wll be loop and a lookup. Loop is T=O(n) Space Complexity is S=O(1)
        public static int[] TwoSumMap(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            //Since we loop through all elements Time complexity will be O(n)
            for(int i=0; i < nums.length; i++) {
                int delta = target - nums[i];

                if (map.containsKey(delta)) {
                    //we found the pair
                    //Tricky - it is not - return new int[]{ i, map.get(delta)};
                    return new int[]{ map.get(delta), i};
                }
                map.putIfAbsent(nums[i], i);
            }

            //What should be the expected behavior? ask
            return new int[]{-1, -1};
        }


        public static void main(String[] args) {

            //int[] result = BruteForce(new int[]{2,7,11,15}, 9);
            //int[] result1 = BruteForce(new int[]{2,2,7,11,15}, 9);
            //int[] result2 = BruteForce(new int[]{2,9,3,7,6,11,15}, 9);
            //int[] result3 = BruteForce(new int[]{2,2,2,3,2,2}, 9);
            //int[] result4 = BruteForce(new int[]{}, 9);
            //int[] result5 = BruteForce(new int[]{-4,2,3,13}, 9);
            //int[] result6 = BruteForce(new int[]{1,1,1,1}, 2);

            int[] result = TwoSumMap(new int[]{2,7,11,15}, 9);
            int[] result1 = TwoSumMap(new int[]{2,2,7,11,15}, 9);
            int[] result2 = TwoSumMap(new int[]{2,9,3,7,6,11,15}, 9);
            int[] result3 = TwoSumMap(new int[]{2,2,2,3,2,2}, 9);
            int[] result4 = TwoSumMap(new int[]{}, 9);
            int[] result5 = TwoSumMap(new int[]{-4,2,3,13}, 9);
            int[] result6 = TwoSumMap(new int[]{1,1,1,1}, 2);

            System.out.println("The result int[]{2,7,11,15}, target 9 is " + Arrays.toString(result));
            System.out.println("The result int[]{2,2,7,11,15}, target 9 is " + Arrays.toString(result1));
            System.out.println("The result int[]{2,9,3,7,6,11,15}, target 9 is " + Arrays.toString(result2));
            System.out.println("The result int[]{2,2,2,3,2,2}, target 9 is " + Arrays.toString(result3));
            System.out.println("The result int[]{}, target 9 is " + Arrays.toString(result4));
            System.out.println("The result int[]{-4,2,3,13}, target 9 is " + Arrays.toString(result5));
            System.out.println("The result int[]{1,1,1,1}, target 2 is " + Arrays.toString(result6));

        }

}
