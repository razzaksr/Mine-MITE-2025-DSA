package day6;

/*
 * 
   int target1 = 12;
   int[] position1 = {10, 8, 0, 5, 3};
   int[] speed1 = {2, 4, 1, 1, 3};
   time[5]={}
   time=[1.0,1.0,12.0,7.0,3.0]>> t-p[i]/s[i]
   indices[5]=[]
   indices=[0,1,2,3,4]
   sort indices based on descending order of position
   indices=[0, 1, 3, 4, 2]

   stk=[]
   iterations:
   i=0, idx=0
   stk=[1.0]

   i=1, idx=1
   no action

   i=2, idx=3
   stk=[1.0,7.0]

   i=3, idx=4>>3.0
   stk=[1.0,7.0]

   i=4, idx=2, >> 12.0
   stk=[1.0,7.0,12.0]
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
        System.out.println(Arrays.toString(indices));

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

