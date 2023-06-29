/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    String filePath = "/home/coderpad/data/example1.txt";  // Update the file path as needed
        try {
            Map<String, List<String>> anagramGroups = groupAnagramsFromFile(filePath);
            printAnagramGroups(anagramGroups);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
  }
  private static Map<String, List<String>> groupAnagramsFromFile(String filePath) throws IOException {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = reader.readLine()) != null) {
                String sortedWord = sortCharacters(word);

                if (!anagramGroups.containsKey(sortedWord)) {
                    anagramGroups.put(sortedWord, new ArrayList<>());
                }
                anagramGroups.get(sortedWord).add(word);
            }
        }
    return anagramGroups;
  }

  private static String sortCharacters(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
  }

  private static void printAnagramGroups(Map<String, List<String>> anagramGroups) {
        for (List<String> group : anagramGroups.values()) {
            Set<String> uniqueWords = new LinkedHashSet<>(group); // Use LinkedHashSet to preserve order and remove duplicates
            System.out.println(String.join(",", uniqueWords));
        }
  }

}

