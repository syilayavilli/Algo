package Challenge.Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
//Interview problem asked in different ways

//Two conditions to satisfy
//isVisited and is same path - if path is alive - isAlive
//We could revisit a node from a different path and may not be cycle
//so we need to reset the isAlive
//Both of these are node specific

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DetectCycleInGraph {

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

        //Template BFS
        void printGraphUsingBFS() {
            boolean[] isVisited = new boolean[V];
            Deque<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < adjList.length; i++) {
                if (!isVisited[i]) {

                    queue.offer(i);
                    isVisited[0] = true;

                    while (!queue.isEmpty()) {
                        Integer v = queue.poll(); //remove the first head frm th queue, we get integer node

                        //process v now
                        //Queue -> 0 1 4 2 3 3 4
                        //since duplicated - we need to keep track of visited as the problem is to visit a node once
                        //print a node once
                        System.out.print(v + " ");

                        //Get all the neighbors for v (which is a node in the graph)
                        LinkedList<Integer> list = adjList[v];
                        //what if no neighbors exists
                        if (list != null) {
                            for (Integer c : list) {
                                if (c != null) {
                                    if (!isVisited[c]) {
                                        queue.offer(c);
                                        isVisited[c] = true;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

        void printGraphUsingDFS() {
            boolean[] isVisited = new boolean[V];

            for (int i = 0; i < adjList.length; i++) {

                if (!isVisited[i]) {
                    dfs(i, isVisited);
                }

            }

        }

        void dfs(Integer v, boolean[] isVisited) {

            isVisited[v] = true;
            System.out.print(v + " " ); // process the node v

            LinkedList<Integer> list = adjList[v]; //get neighbors
            if (list != null) {
                for (Integer c : list) {
                    if (c != null && !isVisited[c]) {
                        dfs(c, isVisited);
                    }

                }
            }
        }


        boolean isCycle() {
            boolean[] isVisited = new boolean[V];
            boolean[] isAlive = new boolean[V];

            for(int i=0; i< adjList.length; i++) { //for each node in the Graph
                if(!isVisited[i]) {
                    if(dfsCycle(i, isVisited, isAlive)) {
                        return true;
                    }
                }
            }
            return false; // no cycle found
        }

        public boolean dfsCycle(Integer v, boolean[] isVisited, boolean[] isAlive) {
            isVisited[v]= true;
            isAlive[v]= true;

            LinkedList<Integer> list = adjList[v]; //get neighbors of v or all vertices connected to v
            if (list != null) {
                for (Integer c : list) {
                    //System.out.println("neighbor  is " + c );
                    if (c != null && !isVisited[c]) { // not visited
                        if(dfsCycle(c, isVisited, isAlive)) {
                            return true;
                        }
                        isAlive[v] = false; //backtrack because of the path
                    } if (c != null && isVisited[c] && isAlive[c]) { // is is Visited & Alive also which means there is a cycle
                        System.out.println("Found cyclic node  is " + c );
                        return true;  //if cycle just simply return
                    }
                }
            }
            //isAlive[v] = false; //backtrack because of the path
            System.out.println("v is " + v + " isAlive is " + isAlive[v]);
            return false; //no cycle found so return false.
        }

    }

    public static void main(String[] args) {
        //directed graph of 6 nodes
        //and this is not cyclic
        Graph graph = new Graph(7);// 6

        //Create relationships between nodes
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6); //2,0

        graph.addEdge(3, null);
        graph.addEdge(4, null); //4 null

        //This edge will not get touched because of the direction which is incoming edge
        //so to touch this, we need a for loop
        graph.addEdge(5, 2);

        //print all the nodes in the graph using BFS

        System.out.println("Print BFS");
        graph.printGraphUsingBFS();
        System.out.println("");
        System.out.println("Print DFS");
        graph.printGraphUsingDFS();

        System.out.println();
        System.out.println("is Cycle: "  + graph.isCycle());
    }

}
