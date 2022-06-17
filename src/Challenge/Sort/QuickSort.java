package Challenge.Sort;
// Quick Sort does not mean it is quick
//Imagine - classroom that there are students of different height
// Teacher - says - all of you look at yourself and you know how tall yo are
//arrange yourself and arrange sort yourselves from short to tall

import java.util.Arrays;

//divide and conquer algorithm - we select a pivot
// it could be selected for many reason - first element, last , middle or random number
// or java uses median of three numbers (sort list of numbers and the middle of sorted data
// is median data. Average/mean is sum of numbers divided by the number
// Choose Pivot as the last element or first element
// pivot is like a pointer
// say 8 2 6 8 1
public class QuickSort {

    public static void main(String[] args) {
        int[] ary = {5, 1, 6, 8, 3, 7, 2};
        System.out.println("before start: " + Arrays.toString(ary));
        quickSort(ary);
        System.out.println("before start: " + Arrays.toString(ary));
    }

    static void quickSort(int[] ary) {
        quickSort(ary, 0, ary.length -1);
    }

    static void quickSort(int[]ary, int start, int end) {

        if(start < end) {

            int pivotIdx = partition(ary, start, end); //Partitions the array at the pivot index, so all elements less than
                                        // the pivot are on the left and greater are on the right
            /*
            can select pivot here and pass to partition(ary, start, end, pivot)
            for asc - After call to partition function all elements on left are less than pivot and all elemnts
            on right are greater than pivot
            quickSort function called for left side
            quickSort function called for right side
            */

            //Note PivotIdx should not be included as the pivot is at the right place
            quickSort(ary,start, pivotIdx-1);
            quickSort(ary, pivotIdx+1, end) ;
        }

    }

    static int partition(int[] ary, int start, int end) {
        //Select pivot here or can also be selected in the calling function
        //Select pivot
        //Select last element as pivot
        int pivot = ary[end];

        //start comparison from the begining of that partition with the pivot
        int pivotIdx = start;
        for (int j = start; j < end; j++ ) { //find the correct pivotIdx and move all values less than the pivot on the left of pivotIdx
             if (ary[j] < pivot){
                 //we should swap the data
                 swap(ary, pivotIdx, j);
                 pivotIdx++;
             }
        } // here we have found the pivotIdx
        swap(ary, pivotIdx, end); // we found the right place for the pivot, so move pivot there
          // at this point the pivot will be at the right place.
        return pivotIdx;


    }

    static void swap(int[] ary, int a, int b ) {
        int temp = ary[a];
        ary[a] = ary[b];
        ary[b] = temp;
    }
}
