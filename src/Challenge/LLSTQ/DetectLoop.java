package Challenge.LLSTQ;


//Remove the loop by setting the next value to null

// 1-------N0start of loop
//N0 is the number of node till the start of the loop
//K is the point where both of the pointers meet
// N0 + C1 L - K = N
// N0 + C2 L - K = 2N
//  N0 + C2 L - K = 2(N0 +C1 L - K)
//     N0 =  K + (C2 - 2C1 )L
public class DetectLoop {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    //head - head of the linked list
    // return the starting
    public ListNode detectloop(ListNode head) {

        ListNode pointer1 = head;
        ListNode pointer2 = head;
        boolean start = false;
        while(pointer1 != pointer2 || start) {
            start = false;
            pointer1 = pointer1.next;
            if (pointer2 != null && pointer2.next != null) {
                pointer2 = pointer2.next.next;
            } else {
                return null;
            }
        }
        pointer1 = head;
        while(pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
