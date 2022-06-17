package Challenge.Strings;
/*
Revers Index problem

Given a large file (once) and a word (once) find the locations of the word in the file.

int[] findlocations(File file, String word)

Read the file in a while loop find the word

open file
read words (split functions) list of words
iterate in the words and see if the given word matches
if match store the location addLocation to a list

class ReadLocations {
  File file;
  ReadLocations(File file) {//constructor //called once
    this.file = file;
  }
  int[] findLocations(String word) { //called multiple times
      open file
      read word
      iterate
      if matches
        addLocations
  }
}

preprocess file and put all words in hashmap
Break file into words
instead of splitting every line and finding match

Hash Map Key as words and Values as Locations
apple  3 locations 2, 8, 25
pear  1, 5 ,7

The above is called "Reverse Index"

Search Engines yahoo, google
Analyzer - removing
tokenizer - breaking line into token

Other way is use of Trie  store locations of words
we can do prefix search

 */
public class FindLocationOfWordInFile {
}
