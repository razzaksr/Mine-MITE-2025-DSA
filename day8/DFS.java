package day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

public class DFS {
    public static void dfsTraversal(Hashtable<Integer,List<Integer>> graph, int begin, TreeSet<Integer> visited){
        if(visited.contains(begin)){
            return;
        }
        visited.add(begin);
        System.out.print(begin+" -> ");
        // traversal
        for(int visit:graph.getOrDefault(begin, Collections.emptyList())){
            dfsTraversal(graph, visit, visited);
        }
    }
    public static void main(String[] args) {
        Hashtable<Integer,List<Integer>> graph = new Hashtable<>();
        graph.put(0, Arrays.asList(1, 3));
        graph.put(1, Arrays.asList(0, 2, 4));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(0, 4));
        graph.put(4, Arrays.asList(1, 3));

        dfsTraversal(graph, 0, new TreeSet<>());
        System.out.println("reached");
    }
}
