package day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumFinder {
    // Method to find two numbers that add up to the target
    public static List<Integer> findTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList();

        for (int num : arr) {
            int complement = target - num;

            if (map.containsKey(complement)) {
                result.add(complement);
                result.add(num);
                break;
            }
            map.put(num, 1); // Store the number in the map
        }

        return result;
    }

    public static void main(String[] args) {
        int[] transactions = {2, 7, 11, 15};
        int target = 9;

        List<Integer> result = findTwoSum(transactions, target);

        if (!result.isEmpty()) {
            System.out.println("Two sum pair: " + result);
        } else {
            System.out.println("No valid pair found.");
        }
    }
}
