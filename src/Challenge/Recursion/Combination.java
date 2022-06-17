package Challenge.Recursion;

import java.util.*;

//https://leetcode.com/problems/combinations/ LeetCode 77 Medium
//Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
//        You may return the answer in any order.
//        Input: n = 4, k = 2
//        Output:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]


public class Combination {

    public static List<List<Integer>> combine(int n, int k) {
        //if k == 0 return an empty set
        List<List<Integer>> ans = new LinkedList<>();
        if (k == 0) {
            ans.add(new LinkedList<>());
            return ans;
        }
        combine_helper(1, new LinkedList<>(), n, k, ans);
        return ans;
    }

    public static void combine_helper(int start, LinkedList<Integer> current, int n, int k, List<List<Integer>> ans) {

        //base condition if the current list is of size k add to the ans set
        if (current.size() == k) {
            System.out.println(current.toString());
            ans.add(new LinkedList(current));
        }

        for(int i = start; i <= n && current.size() < k; i++) {
            current.add(i);
            combine_helper(i+1, current, n, k, ans);

            //backtrack
            current.removeLast();
        }
    }

    public static void main (String args[]) {
        List<List<Integer>> ans = combine(4, 2);
    }
}
