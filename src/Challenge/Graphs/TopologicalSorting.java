package Challenge.Graphs;
/*
https://www.youtube.com/watch?v=z-mB8ZL6mjo
https://www.youtube.com/watch?v=LA0X_N-dEsg

A topological sort or ordering of a directed graph is a linear ordering o fits vertices such that the for every directed edge UV from vertex u to vertex v, u comes before v in the ordering.

For instance, the vertices of the graph may represent tasks to be performed, and gthe edges may represent the constraint that one task to be performed before another; in this application a tolpological ordering is just a a vlid sequence for the atsks

Note: Topological sort or oerdering is possible only for graph with no directed cycles, that is if it is a acuclic directed graph (DAG). Any DAG has atleast one toplogical ordering, and algorithms are known for constructing a topologocal ordering of any DAG in linera time.

Topological Sorting
Kahn's algorithm
Indegree array, use queue to fo a BFS.Offer all nodes with 0 indegree to the queue


a-> b -> d
a-> c -> d

we need int[] indegree[26], for every node we will find what is the indegree
for edge a-> b and edge a -> c
the node a has 0 indegree but b and c have an indegreen of 1, similarly d has an indegree of 2 one from b and one from c
Since a does not have an indegree which means we can perform this task first,
We will offer a into the queue
   while the queue is not empty:
      current node =  q.poll();
      check all the neighbors nodes of current node
      reduce the indegree by 1 indegree[]--;
      if indegree[] ==0
        queue.offer();

a|b|c|
when b is poll (because indegree iss zero) the neighbor is d we add (because indegree iss zero) and decrement by 1 from 2 but we dont offer d yet (we offer only when indegree is is zero, but d is at 1 not 0), when and again when we poll c
d is decremented from 1 to 0 and then d is offered (we offer only when indegree is is zero)...

Wer can get the topological sort (we may have more than 1 possibiloity
abcd
or:
acbd

current node is a and we will check all the neighbors of a which is b and c
the final answer could ve a b c d or acbd

a-> b ->c and c->a This is cyclic. All of these has indegree 1 and are never zero,

a->b->c
a->c->b
the above two makes a cycle.  All of these has indegree 1 and are never zero


 */
public class TopologicalSorting {
}
