package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// Not usig POJO

public class SortKLinkedList {
    public static List<Integer> performMerge(List<LinkedList<Integer>> src){
        List<Integer> merged = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(List<Integer> each:src){
            priorityQueue.addAll(each);
        }

        while(!priorityQueue.isEmpty()){
            merged.add(priorityQueue.poll());
        }

        return merged;
    }
    public static void main(String[] args) {
        List<LinkedList<Integer>> lists = new ArrayList<>();
        
        lists.add(new LinkedList<>(Arrays.asList(1, 5, 4)));
        lists.add(new LinkedList<>(Arrays.asList(3, 4, 1)));
        lists.add(new LinkedList<>(Arrays.asList(2, 6)));

        List<Integer> got = performMerge(lists);
        System.out.println(got);
    }
}
