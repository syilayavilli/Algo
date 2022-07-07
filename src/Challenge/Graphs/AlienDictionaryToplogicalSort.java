package Challenge.Graphs;

import java.util.*;

//leet code 268
//There is a new alien language which uses latin. However, the order among letters are unknown to you
//You receive a list of non-empty words from the dictionary, where words are sorted
//lexicographically by the rules of this new language. Derive the order of the letters
//in this new language

//example
//{
//   "wrt", |
//   "wrf", |   t comes before f
//   "er",     | w comes before e
//   "ett",    | r comes before t
//   "rftt"    | e comes before r
//  }                   w  e  r  t  f
//output "wertf"

//Solution - In normal dictionary "azd" is before "zad"
// so thw words start with 'a' is before the words starting with 'b'
// we compare the first different char letter

//Algorithm : We try to build an order that fulfils the relationship given

//Relationship: The order of two chara a -> b
// we can use the graph to represent  the relationship 'a' is before 'b'
// a has an out edge pointing to an in char 'b', a directed edge.

//Topological Sorting
// A topological ordering is possible only when a directed graph is
// not cyclic
// We need an ADG - Acyclic Directed Graph. See below example

//example
//{
//   "z",
//   "x", | z comes before x
//   "z", | x comes before z
//  }
//output ""

//Derive the order of the letters in this alien language
//Get the topological sort of all letters
//Wrap up:
//   1. Build Graph
//   2. Topological Sorting

//Note: In this we use only small letters so we need an indegree array of 26 characters
public class AlienDictionaryToplogicalSort {

    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        //We need to build the graph - we need to use the adjacency list
        Map<Character, Set<Character>> g = new HashMap<>();

        //Build Graph
        //Build the toplogical order
        buildGraph(g, words, indegree);

        return bfs(g, indegree);
    }

    private void buildGraph(Map<Character, Set<Character>> g, String[] words, int[] indegree){

        //for (String in words)
        for( String word : words ) {
            for (Character c : word.toCharArray()) {
                g.putIfAbsent(c, new HashSet<>());
            }
        }

        //for each compare the first different char
        for (int i=1; i< words.length; i++) {
            String first = words[i-1];
            String second = words[i];
            //find the min len tp which we want to traverse to find the different char
            int len = Math.min(first.length(), second.length());

            for(int j = 0; j < len; j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    char out = first.charAt(j);
                    char in = second.charAt(j);

                    if (!g.get(out).contains(in)) {
                        g.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                    //once one difference is found we dont need to go through others just break
                    break;
                }
            }
        }

    }

    //Topological Sorting
    private String bfs(Map<Character, Set<Character>> g, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        //total node in the graph is
        int totalChars = g.size();
        Queue<Character> queue = new LinkedList<>();
        for (char c : g.keySet()) {
            if (indegree[c - 'a'] == 0) {
                System.out.println("C-" + c +  "contains" + (c-'a'));
                sb.append(c);
                queue.offer(c);
            }
        }

        while (!queue.isEmpty ()) {
            //get neighbor nodes
            char cur = queue.poll();
            //May have no neighbor node
            if (g.get(cur) == null ||  g.size() == 0 )  continue;

            for (char neighbor : g.get(cur)) {
                //we should decrease the indegree by one
                indegree[neighbor - 'a']--;
                System.out.println("neighbor-" + neighbor +  "contains" + (neighbor-'a'));
                if (indegree[neighbor - 'a'] == 0) {
                    System.out.println("neighborZZZ-" + neighbor +  "contains" + (neighbor-'a'));
                    queue.offer(neighbor);
                    sb.append(neighbor);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        AlienDictionaryToplogicalSort a = new AlienDictionaryToplogicalSort();
        System.out.println(a.alienOrder(words));
    }
}
