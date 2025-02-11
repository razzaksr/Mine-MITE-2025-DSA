package day5;

import java.util.*;

// Sliding Window Maximum

public class HeartRateMonitor {

    // Method to find the maximum heart rate for each sliding window of size k
    public static int[] maxHeartRates(int[] heartRates, int k) {
        if (heartRates == null || heartRates.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = heartRates.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller values from the back of the deque
            while (!deque.isEmpty() && heartRates[deque.peekLast()] <= heartRates[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offerLast(i);

            // Store the maximum for the current window
            if (i >= k - 1) {
                result[i - k + 1] = heartRates[deque.peekFirst()];
            }
        }

        return result;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] heartRates = {72, 80, 75, 90, 85, 92, 88};
        int k = 3;

        int[] maxRates = maxHeartRates(heartRates, k);

        System.out.println("Maximum heart rates for each sliding window:");
        System.out.println(Arrays.toString(maxRates));
    }
}
