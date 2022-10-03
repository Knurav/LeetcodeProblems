import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/

public class TwoSum {
    public static void main(String[] args) {
        // Case 1
        int nums[] = new int[] { 2, 7, 11, 15 };
        int k = 9;
        int solution[] = new int[] { 0, 1 };
        long startTime = System.nanoTime();
        int result[] = twoSum(nums, k);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        validateResult(result, solution, duration);

        // Case 2
        nums = new int[] { 3, 2, 4 };
        k = 6;
        solution = new int[] { 1, 2 };
        startTime = System.nanoTime();
        result = twoSum(nums, k);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        validateResult(result, solution, duration);

        // Case 3
        nums = new int[] { 3, 3 };
        k = 6;
        solution = new int[] { 0, 1 };
        startTime = System.nanoTime();
        result = twoSum(nums, k);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        validateResult(result, solution, duration);
    }

    public static void validateResult(int[] Computed, int[] Expected, long duration) {
        if (Arrays.equals(Computed, Expected)) {
            System.out.println("Test Case Passed");
            System.out.println("Time Taken: " + String.valueOf(duration) + "ms");
        } else {
            System.out.println("Test Case Failed");
            System.out.println("Time Taken: " + String.valueOf(duration) + "ms");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> distanceToIndex = new HashMap<>();
        int[] out = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int distance = target - nums[i];
            if (distanceToIndex.keySet().contains(nums[i])) {
                out[0] = distanceToIndex.get(nums[i]);
                out[1] = i;
                return out;
            }
            distanceToIndex.put(distance, i);
        }

        return out;

    }

}
