package Challenge.Graphs;

//This is prelude to the BinaryMatrix island problem of connected graphs
//We create an undirected graph - the edge is from both sides
//BFS
/*
Start with a node, p.offer(n)
while !q.empty , we poll and get neighbors
add in queue
for all graphs - use a for loop on the top for( each node find connected nodes)
We can have a count++ after completing each group
We also need to use isVisited
     //BFS
     for(each node)
        if !isVisited {
         p.offer(n)

         while(!q.isEmpty) {
             ---
             get neighbors;
         }
         count++;
        }
     }


     //DFS
     for (each node) {
         if !isVisited {
            dfs(n);
            count++;
         }
     }

     void dfs(Node n) {
        get all neighbors
        dfs(--)
     }
 */

import java.util.LinkedList;

//print number of connected components
public class ConnectedComponents {

    static class UndirectedGraph {
        int V;

        LinkedList<Integer>[] adjList;

        public UndirectedGraph(int vertices) {
            V = vertices;
            adjList = new LinkedList[V];
        }

        public void addEdge(int vertex, int c) {
            LinkedList<Integer> list = adjList[vertex];
            if (list == null) {
                list = new LinkedList<Integer>();
            }
            list.add(c);
            adjList[vertex] = list;
        }

        public void printGraphUsingDFS() {
            boolean[] isVisited = new boolean[adjList.length];

            for (int i = 0; i < adjList.length; i++ ) {
                if(!isVisited[i] ) {
                    dfs(i, isVisited);
                }
            }
        }

        public void printNumberOfConnectedComponents(){
            boolean[] isVisited = new boolean[adjList.length];
            int count = 0;

            for (int i=0; i < adjList.length; i++) {
                if(!isVisited[i]) {
                    dfs(i, isVisited);
                    count++; //count number of connected components
                }
            }
            System.out.println("Number of connected components are " + count);
        }

        public void dfs(int i, boolean[] isVisited) { //36:05

            isVisited[i] = true;
            System.out.print(i + " ");

            LinkedList<Integer> list = adjList[i];
            if (list != null) {
                for (Integer v : list) {
                    if (v != null && !isVisited[v])
                        dfs(v, isVisited);
                }
            }
        }

        public boolean isCycle() {
            boolean[] isVisited = new boolean[adjList.length];
            boolean[] isAlive = new boolean[adjList.length];

            for(int i = 0; i < adjList.length; i++) {
                if (!isVisited[i]) {
                    if (isDFSCycle(i, isVisited, isAlive)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isDFSCycle(Integer v, boolean[] isVisited, boolean[] isAlive) {
            isVisited[v]= true;
            isAlive[v]= true;

            LinkedList<Integer> list = adjList[v]; //get neighbors of v or all vertices connected to v
            if (list != null) {
                for (Integer c : list) {
                    if (c != null && !isVisited[c]) { // not visited
                        if(isDFSCycle(c, isVisited, isAlive)) {
                            return true;
                        }
                    } if (c != null && isVisited[c] && isAlive[c]) { // is is Visited & Alive also which means there is a cycle
                        return true;  //if cycle just simply return
                    }
                }
            }
            isAlive[v] = false; //backtrack because of the path

            return false; //no cycle found so return false.
        }

    }



    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);

        //graph.printGraphUsingBFS(graph);

        graph.printNumberOfConnectedComponents();
    }
}
