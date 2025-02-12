package day6;

/*
 * 
 */

import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30, 40, 50, 60};
        int[] temperatures3 = {30, 60, 90};

        int[] result1 = dailyTemperatures(temperatures1);
        int[] result2 = dailyTemperatures(temperatures2);
        int[] result3 = dailyTemperatures(temperatures3);

        System.out.println("Input: [73, 74, 75, 71, 69, 72, 76, 73]");
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Input: [30, 40, 50, 60]");
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Input: [30, 60, 90]");
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
