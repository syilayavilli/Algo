package Challenge.Sort;

import java.util.Arrays;

//Divide and conquer algorithm - these are dne recursively
//Divide the data in half
public class MergeSort {
    public static void main(String[] arge) {
        int[] ary = {2, 5, 7, 8, 2, 1, 3, 9};
        System.out.println("before start: " + Arrays.toString(ary));
        mergeSort(ary);
        System.out.println("before start: " + Arrays.toString(ary));
    }

    static void mergeSort(int[] ary) {
        mergeSort(ary, 0, ary.length -1);
    }

    static void mergeSort(int[] ary, int start, int end) {

        if (start < end) {

            //int mid = ary.length / 2; //Will not work as the ary will not change
            int mid = (start + end) /2 ;
            //If the array is too large - this will become int overflow... use the below
            //int mid = start + ((end-start)/2)
            mergeSort(ary, 0, mid ); // left side
            mergeSort(ary, mid+1, end); //right side

            //now merge the above two virtually sorted arrays
            merge(ary, start, mid, end); // or merge(ary, start, mid, mid+1, end);
            //start to mid is first array
            //mid+1 to end in the second array
        }
    }

//    static void merge(int[] ary, int leftstart, int leftend, int rightstart, int rightEnd) {
//
//    }

    static void merge(int[] ary, int start, int mid, int end) {

        //create physical array
        int[] leftArray = new int[mid+1 - start];
        int[] rightArray = new int[end - mid];

        //im-place merge is complicated - one way is as below
        //copy the sorted arrays to temp and then merge the results
        //in original array
        for (int i=0; i < leftArray.length; i++) {
            leftArray[i] = ary[start+i]; //copy the original (sorted) array to temp arrays
        }

        for (int i=0; i < rightArray.length; i++) {
            rightArray[i] = ary[mid+i];
        }
        int leftIdx = 0;
        int rightIdx = 0;
        while(leftIdx < leftArray.length && rightIdx < rightArray.length) {

            if (leftArray[leftIdx] <= rightArray[rightIdx]) { //stable sort
                ary[start] = leftArray[leftIdx];
                start++;
                leftIdx++;
                //or ary[start++] = leftArray[leftIdx++];
            } else {
                ary[start] = rightArray[rightIdx];
                start++;
                rightIdx++;
                //or ary[start++] = rightArray[rightIdx++];
            }
            //There could be some left overs that we have to consider

            //The below will happen when the number of elements is odd
            //Copy for remaining left

            while(leftIdx < leftArray.length) {
                ary[start] = leftArray[leftIdx];
                start++;
                leftIdx++;
            }

            while(rightIdx < rightArray.length) {
                ary[start] = rightArray[rightIdx];
                start++;
                leftIdx++;
            }

        }

    }
}
