package Challenge.Strings;

import java.util.HashMap;
import java.util.Map;

public class Trie2021 {

    private static class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        boolean isWord;

        TrieNode(char c) {
            this.ch = c;
            map = new HashMap<>();
        }
    }

    //root will have a null character
    //This is using Trie with Map
    private static class Trie {

        static TrieNode root;

        Trie() {
            root = new TrieNode((char)0); //initialize root node as null
        }

        void add(String word) {

            TrieNode t = root; //as we need to add ch as children to a root level
            //Above is key for all Trie examples

            // add say "apple" for  "a" - check if "a" is already there
            //for the word - go through characters
            for (int i = 0; i<word.length(); i++) {
                char ch = word.charAt(i);
                //get hold of the root TrieNode
                //check lookup the ch if ch alrady exists
                TrieNode child = t.map.get(ch);
                //do a null check
                if (child == null) {
                    //Add a new TriNode
                    child = new TrieNode(ch);
                    t.map.put(ch, child);
                    //p should go as child of "a"
                    ;
                }
                t = child;
            } //end of for loop - processed all char of word

            t.isWord = true;
        }

        void print() {
            //apple

            TrieNode t = root; //This is key for all Trie example

            for (TrieNode node : t.map.values()) {
                StringBuilder strBuilder = new StringBuilder();
                dfs(node, strBuilder); //go recursively
            }

        }

        private void dfs(TrieNode node, StringBuilder strBuilder) {
            //process the node
            strBuilder.append(node.ch);

            if(node.isWord) {
                //We should have built to print the whole string
                System.out.println(strBuilder);
                //resetting strBuilder here will cause problem
            }

            //gather all the child nodes

            for (TrieNode n : node.map.values()) {
                //we don't have base condition because the values have fixed length
                dfs(n, strBuilder);
            }

            //The key is the strBuilder needs to be reset - backtracling
            //on back tracking we have to remove last character
            strBuilder.deleteCharAt(strBuilder.length()-1);

            return; //optional
        }

        private static boolean search(String word) { //"axe"
            /*
            expectation
             */
            TrieNode t = root;

            for(int i =0; i<word.length(); i++) {

                char ch = word.charAt(i);

                TrieNode child = t.map.get(ch);

                //not find the char , word is not there
                //stop and come out x under a is not there
                if(child == null) {
                    return false; //"axe" "x" does not exist
                } else {

                    if(child.isWord && i== word.length()-1) {
                        return true;
                    }

                }
                //continue with the child
                t = child;
            }// end of for loop
            return false;
        }

        boolean startsWith(String prefix) {
            TrieNode t = root;

            for(int i = 0; i<prefix.length(); i++) {
                char ch = prefix.charAt(i);
                TrieNode child = t.map.get(ch);
                if(child == null) {
                    return false;
                }
                t = child;
            } //end of for  loop
            return true;
        }

    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        /*
            Trie class has a root node of type TrieNode which has a character ch and a map
            which will have a key and value

            Trie root node ch = char'0' for root node
            and empty hash
            K V


         */


        trie.add("apple");
        /*
              #
             /
            a
           /
          p *
          /
         p
         /
        l
        /
        e

         */
        trie.add("app");
        /*
            Has Map
            a   object  TrieNode which char p and Map
                  P Object
                  p Object This object will have isWord = true
                  l Object
                  e Object This object will have isWord = True

             h   Object TriNode
                 e
                 l
                 p
        */
        trie.add("hi");
        trie.add("hip");
        trie.add("he");

        trie.print();
        System.out.println("Search app: " + trie.search("app"));
        //Prefix search
        System.out.println("Search app: " + trie.search("app"));
        //Another type is steam of characters coming in... then use Trie
    }
}
