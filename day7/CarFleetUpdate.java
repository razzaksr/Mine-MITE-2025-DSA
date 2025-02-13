package day7;

import java.util.Arrays;
import java.util.Stack;

public class CarFleetUpdate {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] indices = new Integer[n];

        // Step 1: Store indices and sort them based on position in descending order
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        // Step 2: Use a stack to count fleets
        Stack<Double> stack = new Stack<>();
        for (int i : indices) {
            double time = (double) (target - position[i]) / speed[i];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time); // New fleet is formed
            }
        }

        return stack.size(); // Number of fleets
    }

    public static void main(String[] args) {
        // int target1 = 12;
        // int[] position1 = {10, 8, 0, 5, 3};
        // int[] speed1 = {2, 4, 1, 1, 3};
        // int target1 = 3;
        // int[] position1 = {3};
        // int[] speed1 = {3};
        int target1 = 100;
        int[] position1 = {0,2,4};
        int[] speed1 = {4,2,1};
        System.out.println(carFleet(target1, position1, speed1)); // Output: 3
    }
}
