package Challenge.Sort;
//in a 2 dimensional with a given ppoint P and
//n points in a 2D space. Find K points which are
//nearest to Point P.

//n1 - P - 50
//n2 - P - 30
//n3 p - 20
//n4 - p - 10
//n5 - p - 80
//
//Say Value of k = 3
//Answer: n2, n3, n4 in orderder n4, n3, n2

//Questions to ask: Euclidian method for calculations
// How are points denoted in a space - Answer x,y
// what is the scale
// How is the distance - 2 points in a plane using Euclidiam formula

//sqrt(x cordinates of p) + sqrt()
//
//        point p to point c
//x diff p.x - c.x
//y diff p.y - c.y
//
//distance x fiff * x diff + y diff *  y diff)
//The above does not need a sqrt as these will be proportional
//The SQRT calculation is expensive

//2 1 5 3 8 4 9
//
//sort them and we get them in say ascending order
//1 2 3 4 5 8 9
//First k elements from the array will give the k nearest
//answer 1 2 3
//Calculating distance will be constant which can be ignored
//Time complexity n log n for sorting
//then to pick k elements O(k)
//Total O(nlogn) + O(K)
//
//Better option is to make use of priority queues
//
//After calculating distance instead of putting in array we put them in priority queue
//2 1 3 5 8 4 9
//if everything is put in priority queue
//say min heap
//  1
//2     3
//4 5  8 9
//Top 3 or k  will be the answer
//create heap n log
//pull out the values it will be K
//so the above is taking same time nlogn + k

//Other way is reverse way - to use max heap and add only

// Cause the only top (max) can be removed from the top leaving mins
// instead of log n it will be log(K) since the size is limited to k
// .offer() = logK and .poll() log K
// but we are probing through all points n elements
// total complexity will be nlogK instead of nlogn
// O(nlogK + K)
// nlog to prepare the heap and + K to get K values from the heap
// so nlon + K will become nlogk + K
// nlogK is greater than k so it will be nlogK instead of nlogn
// BTW the results are sorted
// In reality it is Offer and poll is nlog k + log K
// O(n 2logK)
// which will become nlogK as we drop the constants

//Bottom line - if we need top 3 use min heap
//Bottom line - if we need min 3 use max heap

//maxheap.offer(n) to add - log n
//maxheap.poll(n) to remove - log n

//better way is Quick Select is other option



//public class PriorityQueue {
//}
