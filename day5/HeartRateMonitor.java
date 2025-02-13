package day5;

import java.util.*;

// Sliding Window Maximum

/*
 * arr = 72, 80, 75, 90, 85, 92, 88
 * k = 3
 * deque = [] , result = []             >> arr.length-k+1>> 5>> store max of each window size of 3
 * 1. remove peekFirst if its not comes under window size(i-k+1) 
       (peekFirst<=i-k+1)and deque is not empty
 * 2. remove peekLast if smaller element compare with current arr[i] 
       and deque is not empty
 * 3. add last of i
 * 4. add peekFirst to results[i-k+1] if i>=k-1>> i>=(3-1)>> i>=2
 * i=0, arr[i]=72
 *      1. no action since deque is empty
 *      2. no action since deque is empty
 *      3. 0 to deque, so deque=[0]
 *      4. no action since window size not obtained
 *
 * i=1, arr[i]=80
 *      1. no action since its comes under the window size only
 *      2. peekLast removed since 72<=80, so deque=[]
 *      3. 1 to deque, so deque=[1]
 *      4. no action since window size not obtained
 * 
 * i=2, arr[i]=75
 *      1. no action since its comes under the window size only
 *      2. no action since 80 !< 75, so deque=[1]
 *      3. 2 to deque, so deque=[1,2]
 *      4. result[0]=arr[1]>> result[0]=80
 *
 * i=3, arr[i]=90
 *      1. remove peekFirst since its not comes under the window size only, 
 *              so deque=[2]
 *      2. peekLast removed since 80<90, so deque=[]
 *      3. 3 to deque, so deque=[3]
 *      4. result[1]=arr[3]>> result=[1]=90
 * 
 * i=4, arr[i]=85
 *      1. no action
 *      2. 90 !< 85, no action
 *      3. 4 to deque, so deque=[3,4]
 *      4. result[2]=arr[3]>> result[2]=90
 * 
 * i=5, arr[i]=92
 *      1. remove peekFirst since its not comes under the window size only, 
 *              so deque=[4]
 *      2. peekLast removed since 90<92, so deque=[]
 *      3. 5 to deque, so deque=[5]
 *      4. result[3]=arr[5]>> result[3]=92
 * 
 * i=6, arr[i]=88
 *      1. no action
 *      2. 92 !<88, no action
 *      3. 6 to deque, so deque=[5,6]
 *      4. result[4]=arr[5]>> result[4]=92
 *          
 */

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
            if (!deque.isEmpty() && deque.peekFirst() <= i - k + 1) {
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
