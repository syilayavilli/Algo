package Challenge.Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//Worst case - The Time complexity of both BFS and DFS is O(V + E)

//Adjacency list
//Shortest distance in terms of number of hops - this will  is using the BFS
//BFS will be level by level like sound waves
//number of hops or cost to reach from src to destination
//this example is about the number of hops
//Example Acyclical directed graph
// 0---->1----->2------->3
// 0---->4----->3
// two paths 0,1,2,3 (3 hops) or 0,4,3 (2 hops)
//Answer will be 2 hops
//We find siblings of 0 which will be 1 and 4 then next siblings of 1 and 4
//which will be 2 and 3 and the first one finding the destination will be the shortest.
//We will count the number of levels as we traverse

//Another example is adjacency matrix
//To find the shortest path (number of hops) in a binary matrix
//given source say (1,1) and destination (4,5) and they are connected by bit 1
// so all bits 1 are used to connect from src to destination like land and ocean
public class ShortestDistance {

    static class HopCount {
        Integer node;
        Integer count;

        HopCount(Integer node, Integer c) {
            this.node = node;
            this.count = c;
        }
    }

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


        //We start with adding node i.e. offer we add the node and count will be zero
        //when we poll and add siblings we add the node and increment the count
        //A-->B and A-->C so A will have count 0 and when we add B and C the count will be count of A plus 1
         int shortestDistance(Integer src, Integer des) {
            //Note: we don't need the for loop as we know the start and the destination
            //and so we don't need to go through all vertices
            boolean[] isVisited = new boolean[V];
            Deque<HopCount> queue = new ArrayDeque<>();

            if (!isVisited[src]) {

                queue.offer(new HopCount(src, 0));
                isVisited[src] = true;

                while (!queue.isEmpty()) {
                    HopCount hopCount = queue.poll(); //remove the first head frm th queue, we get integer node

                    //process v now
                    //Queue -> 0 1 4 2 3 3 4
                    //since duplicated - we need to keep track of visited as the problem is to visit a node once
                    //print a node once
                    System.out.print(hopCount.node + " ");
                    if (hopCount.node == des) { // we found our destination
                        return hopCount.count;
                    }

                    //Get all the neighbors for v (which is a node in the graph)
                    LinkedList<Integer> list = adjList[hopCount.node];
                    //what if no neighbors exists
                    if (list != null) {
                        for (Integer c : list) {
                            if (c != null) {
                                if (!isVisited[c]) {
                                    queue.offer(new HopCount(c,hopCount.count +1));
                                    isVisited[c] = true;
                                }
                            }
                        }
                    }
                }
            }
            return -1; //if destination is not found
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
        graph.addEdge(1, 3);

        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 0);

        graph.addEdge(3, null);

        graph.addEdge(4, null);

        graph.addEdge(5, 2);


        //Shortest distance :

        System.out.println("Shortest distance : " + graph.shortestDistance(0, 3));

    }
}
