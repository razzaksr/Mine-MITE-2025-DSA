package day5;

import java.util.*;

// Minimum Window Substring

public class UserBehaviorAnalysis {
    
    public static List<String> findSmallestWindow(List<String> activities, List<String> requiredActions) {
        // Result window variables
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        // Frequency map to track required actions
        Map<String, Integer> requiredCount = new HashMap<>();
        for (String action : requiredActions) {
            requiredCount.put(action, requiredCount.getOrDefault(action, 0) + 1);
        }

        Map<String, Integer> windowCount = new HashMap<>();
        int left = 0;
        int matched = 0;

        for (int right = 0; right < activities.size(); right++) {
            String currentActivity = activities.get(right);

            // Include current activity in the window
            if (requiredCount.containsKey(currentActivity)) {
                windowCount.put(currentActivity, windowCount.getOrDefault(currentActivity, 0) + 1);

                // Count matching characters only once for valid match
                if (windowCount.get(currentActivity).equals(requiredCount.get(currentActivity))) {
                    matched++;
                }
            }

            // Shrink the window from the left if all required actions are matched
            while (matched == requiredCount.size()) {
                if (right - left + 1 < minLength) {
                    minStart = left;
                    minLength = right - left + 1;
                }

                // Try removing the leftmost element
                String leftActivity = activities.get(left);
                if (requiredCount.containsKey(leftActivity)) {
                    windowCount.put(leftActivity, windowCount.get(leftActivity) - 1);

                    if (windowCount.get(leftActivity) < requiredCount.get(leftActivity)) {
                        matched--;
                    }
                }
                left++;
            }
        }

        // Return the result window
        if (minLength == Integer.MAX_VALUE) {
            return new ArrayList<>(); // No valid window
        }
        
        return activities.subList(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        List<String> activities = Arrays.asList("browse", "search product", "add to cart", "checkout", "feedback");
        List<String> requiredActions = Arrays.asList("search product", "checkout");

        List<String> result = findSmallestWindow(activities, requiredActions);
        System.out.println("Smallest Window: " + result);
    }
}
