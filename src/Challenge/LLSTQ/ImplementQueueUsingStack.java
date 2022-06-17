package Challenge.LLSTQ;
//Queue is not a data structure but an Abstract Data Type
//Queue ADT Abstract Data Type will have a policy to support the following
// .enqueue operation
// .dequeue operation
// The above Queue follows a FIFO structure - First In First Out
// The stack on the contrary follows a LIFO structure - Last In First Out

//Amortized time is the way to express the time complexity
//when an algorithm has the very bad time complexity only once in a while
//besides the time complexity that happens most of time
//(https://medium.com/@satorusasozaki/am...).
// ArrayList in Java is also amortized as the arraylist will double in size when it gets filled up
//amortized analysis - thr real worst case is O(n) for moving from one stack to other but once movwed we dont need to operate O(n)
//The amortized operation will be O(1) cause we dont oftenly move O(n) items frequently
//Time Complexities
// T: O(1)
// S: O(n)

//https://leetcode.com/problems/implement-queue-using-stacks/solution/
//Queue is FIFO (first in - first out) data structure, in which the elements are inserted from
//one side - rear and removed from the other - front. The most intuitive way to implement it is with linked lists,
//but this article will introduce another approach using stacks. Stack is LIFO (last in - first out) data structure,
//in which elements are added and removed from the same end, called top.
//To satisfy FIFO property of a queue we need to keep two stacks.
//They serve to reverse arrival order of the elements and one of them store the queue elements in their final order.
//https://www.youtube.com/watch?v=Wg8IiY1LbII

// Queue 5     2      3
//      front         rear
// Stack  St1     St2
//         3       5
//         2       2
//         5       3


public class ImplementQueueUsingStack {


}
