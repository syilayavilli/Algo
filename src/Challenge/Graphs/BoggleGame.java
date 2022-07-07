package Challenge.Graphs;

import java.util.*;

//You are given a 4*4 matrix of letters and a dictionary, find all the valid words in the matrix.
//Following are the conditions
//1. If a letter is used, the same letter cannot be used again in the same word search.
//2. The word path can be of any direction
//3. There has to be a path of letters forming the word(in other word all the letters in the word
//   must have to be adjacent to one another.

//Can be solved by Graph and strings
//Optimal Solution using Trie


//This is similar to word search
//In word search II. the word path can only go through 4 directions, up, down, left and right
//In this question the path can to any directions
public class BoggleGame {


    public static Set<String> solve(char[][] matrix, Set<String> dictionary) {
        Set<String>  wordsFound = new HashSet<>();

        //logic - This is an undirected graph which needs traversal in all directions i.e. 8
        //mark each as we visit them and unset. DFS is the best approach

        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];

        //Two for loops to go through each element
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[0].length; col++) {

                isVisited[row][col] = true;
                String word =  "" + matrix[row][col];

                dfs(row, col, word, matrix, isVisited, dictionary, wordsFound);

            }
        }
        //logic

        return wordsFound;
    }

    static int[][] directions = new int[][] {
            {0,  1}, //right
            {0, -1}, //left
            {1,  0}, //down
            {1, -1}, //down left
            {1,  1}, //down right
            {-1, 0}, //up
            {-1, 1}, //up right
            {-1, -1} //up left
    };

    static void  dfs(int row, int col, String word, char[][] matrix, boolean[][] isVisited, Set<String> dictionary, Set<String> wordsFound) {

        //Check if the word exists in dictionary
        if (dictionary.contains(word)) {
            wordsFound.add(word);
            return;
        }

        //dfs into  eight directions
        for (int[] d: directions) {
            int newRow = d[0] + row;
            int newCol = d[1] + col;

            if (isValid(newRow, newCol, matrix) && !isVisited[newRow][newCol]) {

                isVisited[newRow][newCol] = true;
                dfs(newRow, newCol, word+matrix[newRow][newCol], matrix, isVisited, dictionary, wordsFound );
                isVisited[newRow][newCol] = false; // backtrack
            }
        }
    }

    static boolean isValid(int row, int col, char[][]matrix) {

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
            return false;
        return true;
    }
    public static void main(String[] args) {

        BoggleGame boggleGame = new BoggleGame();

        Set<String>  wordDictionary = new HashSet<>();
        wordDictionary.add("DATA");
        wordDictionary.add("HALO");
        wordDictionary.add("HALT");
        wordDictionary.add("SAG");
        wordDictionary.add("BEAT");
        wordDictionary.add("TOTAL");
        wordDictionary.add("GLOT");
        wordDictionary.add("DAG");

        char[][] matrix = new char[][] {
                {'D', 'A', 'T', 'H'},
                {'C', 'G', 'O', 'A'},
                {'S', 'A', 'T', 'L'},
                {'B', 'E', 'D', 'G'}
        };

        Set<String> wordsFound = boggleGame.solve(matrix, wordDictionary);
        System.out.println(wordsFound );
    }
}
