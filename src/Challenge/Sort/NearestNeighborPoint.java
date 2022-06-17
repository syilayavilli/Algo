package Challenge.Sort;

import java.util.*;

public class NearestNeighborPoint {

    public static class DistanceComparator implements Comparator<Point> {
        Point c;
        public DistanceComparator(Point c) {
            this.c = c;
        }

        public int compare(Point p1, Point p2) {
            //return value less than 0,  equal to 0 to greater than 0
            return Integer.compare(distance(p2, c), distance(p1, c)) ;
            //above is for descending order which is need for find min 3 - so we need max heap at the top

            //for asc - to find max three we need min heap - minimum at the top
            //return Integer.compare(distance(p1, c), distance(p2, c)) ;

            //Note: We may not need a comparator since the Java default is ascending
            //in this case we need desc , we need to use comparator with p2 first and p1 later
        }
    }

    public static int distance(Point p, Point c ) {
        int xDiff = p.x - c.x;
        int yDiff = p.y - c.y;
        return (xDiff * xDiff) + (yDiff * yDiff);
    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Point p1 = new Point(1,2);
        Point p2 = new Point(30,40);
        Point p3 = new Point(20,30);
        Point p4 = new Point(15,5);
        Point p5 = new Point(1,4);

        //distance to this
        Point c = new Point(15, 30);

        Point[] points = new Point[5];

        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        points[4] = p5;

        int k = 3;

        List<Point> result = getKNearPoints(points, c, k);
        System.out.println("Result: " + result );

    }

    public static List<Point> getKNearPoints(Point[] points, Point c, int k) {
      //Java has priority Queue
        //capacity internal allocation of memory and we limit by k + 1
        PriorityQueue<Point> pQueue = new PriorityQueue<>((k + 1), new DistanceComparator(c));

        // Why DistanceComparator in constructor - reason - it is used for when sorting is needed
        //internally API will look at comparator to put the values in the right place
        //pqueue.offer(some value 1) pqueue.offer(some value 2) uses comparator to sort in some sequence


        for (Point p : points) {
            pQueue.offer(p); //log x
            if(pQueue.size() > k) {
                pQueue.poll(); //log K
            }
        }

        //upto this point o(plogk + log k ) == O(p logK)

        List<Point> result = new ArrayList<Point>();
        Iterator<Point> iter = pQueue.iterator();
        while(iter.hasNext()) {
            Point p = iter.next();
            result.add(p);
        }

        //O(p logk + k) or o(p log k)
        return result;

        //If order is required as additional part of requirement
        // put the result in the array list at index. Use with index k
        // Ask Iqbal bhai -

    }

    //Key is to  explain the approach
}
