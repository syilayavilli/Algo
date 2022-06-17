package Challenge.Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestDistance {

    static class Graph {

        int V; //no of nodes or vertices
        //array of linked list with each index as a vertex
        //or node pointing to its relations
        //it can also be a hashmap with key as a vertex pointing to relations in value
        LinkedList<Integer>[] adjList;

        public Graph(int V) {
            this.V = V;
            adjList = new LinkedList[V];
        }

        public void addEdge(int v, Integer c) {
            LinkedList<Integer> list = adjList[v];
            if (list == null) {
                list = new LinkedList<Integer>();
            }
            list.add(c);
            adjList[v] = list;
                    /*
                    adjList
                    0 | 1 | 4 | |
                    1 | 2 | 3 | |
                    2
                    3
                    4

                     */
        }

        public static int shortestDistance(Integer src, Integer des) {
//            //Note: we dont need the for loop as we know the start and the destination and so
//            //and so we dont need to go through all vertices
//            boolean[] isVisited = new boolean[V];
//            Deque<Integer> queue = new ArrayDeque<>();
//
//            if (!isVisited[i]) {
//
//                queue.offer(i);
//                isVisited[0] = true;
//
//                while (!queue.isEmpty()) {
//                    Integer v = queue.poll(); //remove the first head frm th queue, we get integer node
//
//                    //process v now
//                    //Queue -> 0 1 4 2 3 3 4
//                    //since duplicated - we need to keep track of visited as the problem is to visit a node once
//                    //print a node once
//                    System.out.print(v + " ");
//
//                    //Get all the neighbors for v (which is a node in the graph)
//                    LinkedList<Integer> list = adjList[v];
//                    //what if no neighbors exists
//                    if (list != null) {
//                        for (Integer c : list) {
//                            if (c != null) {
//                                if (!isVisited[c]) {
//                                    queue.offer(c);
//                                    isVisited[c] = true;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
            int dummy=0;
            return dummy;
        }

    }
    public static void main(String[] args) {
        //directed graph of 6 nodes
        //and this is not cyclic
        Graph graph = new Graph(6);

        //Create relationships between nodes
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, null);
        graph.addEdge(4, 3);


        //Shortest distance :

        System.out.println("Shortest distance : " + graph.shortestDistance(0, 3));

    }
}
