package Challenge;

//Leetcode #46 Permutation
//Permutation - number of cases for an array will be n! i.e. 3! = 6 say for [1,2,3], [2,1,3],
// [5,6,7]
// Backtracking kind of problem
// LLSTQNotes: the "i" is the "index" used here

import java.util.Arrays;

public class PermutationArray {

    public static void main(String[] args) {
        int[] ary = {5,6,7};
        perm(ary);
    }

    static void perm(int[] ary) {
        perm(ary, 0);
    }

    static void perm(int[] ary, int index) {

        if (index == ary.length) {
            System.out.println(Arrays.toString(ary));
            return;
        }

        for (int j = index; j < ary.length; j++) {
            swap(ary, index, j);
            perm(ary, index+1);

            //backtracking
            swap(ary, index, j);
        }
    }

    public static void swap (int[] ary, int x, int y) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
}
