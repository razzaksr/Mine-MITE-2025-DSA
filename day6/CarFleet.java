package day6;

/*
 * Explanation:
Step-by-Step Results of Each Iteration:
Example 1:
Input:

target = 12

position = [10, 8, 0, 5, 3]

speed = [2, 4, 1, 1, 3]

Initialization:

Calculate times to reach target: [1.0, 1.0, 12.0, 7.0, 3.0]

Indices: [0, 1, 2, 3, 4]

Sort indices by position: [2, 3, 4, 1, 0]

Processing:

Stack: []

Iteration 1:

Current index: 2, time: 12.0

Stack: [12.0]

Iteration 2:

Current index: 3, time: 7.0

Stack: [12.0, 7.0]

Iteration 3:

Current index: 4, time: 3.0

Stack: [12.0, 7.0, 3.0]

Iteration 4:

Current index: 1, time: 1.0

Stack: [12.0, 7.0, 3.0, 1.0] (No change as time is not greater than top of stack)

Iteration 5:

Current index: 0, time: 1.0

Stack: [12.0, 7.0, 3.0, 1.0] (No change as time is not greater than top of stack)

Result:

Number of car fleets: 3

Example 2:
Input:

target = 10

position = [3]

speed = [3]

Initialization:

Calculate times to reach target: [2.333]

Indices: [0]

Sort indices by position: [0]

Processing:

Stack: []

Iteration 1:

Current index: 0, time: 2.333

Stack: [2.333]

Result:

Number of car fleets: 1

Example 3:
Input:
target = 100
position = [0, 2, 4]
speed = [4, 2, 1]

Initialization:
Calculate times to reach target: [25.0, 49.0, 96.0]
Indices: [0, 1, 2]
Sort indices by position: [2, 1, 0]

Processing:
Stack: []

Iteration 1:
Current index: 2, time: 96.0
Stack: [96.0]

Iteration 2:
Current index: 1, time: 49.0
Stack: [96.0] (No change as time is not greater than top of stack)

Iteration 3:
Current index: 0, time: 25.0
Stack: [96.0] (No change as time is not greater than top of stack)

Result:
Number of car fleets: 1
 */

import java.util.Arrays;
import java.util.Stack;
public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[n];

        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - position[i]) / speed[i];
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (stack.isEmpty() || time[idx] > stack.peek()) {
                stack.push(time[idx]);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        int target1 = 12;
        int[] position1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        System.out.println("Number of car fleets: " + carFleet(target1, position1, speed1)); // Output: 3

        int target2 = 10;
        int[] position2 = {3};
        int[] speed2 = {3};
        System.out.println("Number of car fleets: " + carFleet(target2, position2, speed2)); // Output: 1

        int target3 = 100;
        int[] position3 = {0, 2, 4};
        int[] speed3 = {4, 2, 1};
        System.out.println("Number of car fleets: " + carFleet(target3, position3, speed3)); // Output: 1
    }
}

