package day8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            graph.putIfAbsent(c, new HashSet<>());
        }
        // System.out.println(graph);

        // Build the graph
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int minLength = Math.min(prev.length(), curr.length());

            for (int j = 0; j < minLength; j++) {
                char prevChar = prev.charAt(j);
                char currChar = curr.charAt(j);

                if (prevChar != currChar) {
                    graph.putIfAbsent(prevChar, new HashSet<>());
                    graph.get(prevChar).add(currChar);
                    break;
                }
            }
        }

        // Perform topological sorting using DFS
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();
        for (char c : graph.keySet()) {
            if (!visited.contains(c) && !dfs(c, graph, stack, visited, new HashSet<>())) {
                return "";
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private static boolean dfs(char curr, Map<Character, Set<Character>> graph,
                        Stack<Character> stack, Set<Character> visited, Set<Character> visiting) {
        if (visiting.contains(curr)) {
            return false; // Detected a cycle
        }

        visiting.add(curr);

        for (char neighbor : graph.getOrDefault(curr, new HashSet<>())) {
            if (!visited.contains(neighbor)) {
                if (!dfs(neighbor, graph, stack, visited, visiting)) {
                    return false;
                }
            }
        }

        visiting.remove(curr);
        visited.add(curr);
        stack.push(curr);
        return true;
    }

    public static void main(String[] args) {

        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(words1)); // Output: "wertf"

        String[] words2 = {"z", "x"};
        System.out.println(alienOrder(words2)); // Output: "zx"

        String[] words3 = {"z", "x", "z"};
        System.out.println(alienOrder(words3)); // Output: ""
    }
}
