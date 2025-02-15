package day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class BFS {

    public static void bfsTraversal(Hashtable<Integer,List<Integer>> graph, int begin){
        Queue<Integer> queue = new LinkedList<>();
        TreeSet<Integer> visited = new TreeSet<>();

        queue.offer(begin);visited.add(begin);

        // traversal
        while(!queue.isEmpty()){
            int polled = queue.poll();
            System.out.print(polled+" -> ");
            for(int visit:graph.getOrDefault(polled, Collections.emptyList())){
                if(!visited.contains(visit)){
                    visited.add(visit);
                    queue.add(visit);
                }
            }
        }
        System.out.println("reached");
    }

    public static void main(String[] args) {
        Hashtable<Integer,List<Integer>> graph = new Hashtable<>();
        graph.put(0, Arrays.asList(1, 3));
        graph.put(1, Arrays.asList(0, 2, 4));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(0, 4));
        graph.put(4, Arrays.asList(1, 3));

        bfsTraversal(graph, 0);
    }
}
