package Challenge.Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Merge ovelapping intervals - Popular facebook question once upon a time

Sorted?Duplicate? positive?, negative?

Example 1:
List of intervals - Facebook medium

    start time        End Time
    1:00                3:00
    2:00                6:00
    8:00               10:00
    15:00              18:00

    busy - merge the time which is overlapping
    Output Results
    1 - 3
      2 - 6
    1 - 6 is blocked
    8 - 10
    15 - 18:00


Example 2:

    8:00    12:00
    10:00   11:00
    15:00   18:00
    16:00   20:00

    Output result
      8:00 - 12:00
     15:00 - 20:00

Templates for this kind of problems
-----------------------------------
0   1 2 3  4
|  | | | |   |
Store the first element ary[0]
Start a loop with second elemnet and for end element
process the current
next = ary[i]
---
----
curr = next;
do action to the last element
//process the last element

Check f end of 1 is greater than start of second, then merge witg
start as start of first one and max  of ends as the end


if you merge, save the merge candidate and
compare the next with a merge candidate
if no more merge, print


 */
public class MergeOverlappingIntervals {

    private static class Interval {

        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public String toString() {
            return "[start=" + start + " , end=" +end +"]";
        }

    }


    public static void main (String[] args) {

        Interval int1 = new Interval(1, 3);
        Interval int2 = new Interval(2, 6);
        Interval int3 = new Interval(8, 10);
        Interval int4 = new Interval(2, 18);

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(int1);
        intervalList.add(int2);
        intervalList.add(int3);
        intervalList.add(int4);

        System.out.println("before merge:" + intervalList);
        List<Interval> mergedIntervalList = merge(intervalList);
        System.out.println("after merge:" + mergedIntervalList);


    }

    /*
      1 , 3
      2, 6
     */
    private static List<Interval> merge(List<Interval> intervalList) {

        List<Interval> resultIntervals = new ArrayList<>();
        Collections.sort(intervalList, (intv11, intv12) -> {return intv11.start - intv12.start;});

        Interval currIntv = intervalList.get(0);

        for(int i = 1; i<intervalList.size(); i++) {
            Interval intv = intervalList.get(i);

            if (intv.start <= currIntv.end) {
                //found the candidate to merge
                //And we have to store and will be the new current
                currIntv = new Interval(currIntv.start, Math.max(currIntv.end, intv.end));
            } else {
                resultIntervals.add(intv);
                currIntv = new Interval(intv.start, intv.end);
                //note: currIntv = intv; will mess up
            }//

            //process the last item which was left out
        } //end of for loop

        resultIntervals.add(currIntv); //add the last one
        return resultIntervals;
    }

}
