package Challenge.Arrays;
/*
Leet code 442  - Find Duplicates
https://leetcode.com/problems/find-all-duplicates-in-an-array/




give array of numbers and the range of data in that array int 1 to n
where n is number of elements in an array.
ex:  0 1 2 3 4
     1 3 4 4 2
Print duplicates o/p = 4

ex 2:
    0 1 2 3 4
    1 2 5 2 5
o/p duplicates 2 and 5

solutipn
1. two for loops O(n^2)
2. Sort O(nlog n (sort) + n - for checking prev with current) = nlogn + n =  (nlogn)
3. Maps/Set   T = O(n)
              S = O(n)
4.  T= O(n)
    S= O(1)
    Mark the respective position of the val that is processed as -ve
    to mark that it was seen
    process all the elements

NOTE: 1 to n means has an implicit meaning that the data is index array and values will be jumbled ok
cannot be 25 20 1 20 50
Can there be negative - no as it is 1 to n

 index 1  2  3  4  5
       5  3  4  4  2


 index 1  2  3  4  5  6
       2  3  5  5  4  1



 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {

        int[] input = {2 , 3,  5,  5,  4,  1};
        printDuplicates(input);
    }

    static void printDuplicates(int[] arr) {

        for (int i=0; i< arr.length; i++ ) {


            //not seen (index is zero based
            if(arr[Math.abs(arr[i])-1] >= 0) { //not seen
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
            } else {
                System.out.println(arr[i] + " ");
            }
            System.out.println();
        }

    }
}
