import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;

//https://leetcode.com/problems/top-k-frequent-elements/

class TopKFrequentElements {

    public static void main(String[] args) {
        // Case 1
        int nums[] = new int[] { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int solution[] = new int[] { 1, 2 };
        long startTime = System.nanoTime();
        int result[] = topKFrequent(nums, k);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        validateResult(result, solution, duration);

        // Case 2
        nums = new int[] { 1 };
        k = 1;
        solution = new int[] { 1 };
        startTime = System.nanoTime();
        result = topKFrequent(nums, k);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000;
        validateResult(result, solution, duration);
    }

    public static void validateResult(int[] Computed, int[] Expected, long duration) {
        if (Arrays.equals(Computed, Expected)) {
            System.out.println("Test Case Passed");
            System.out.println("Time Taken: " + String.valueOf(duration) + "ms");
        }else{
            System.out.println("Test Case Failed");
            System.out.println("Time Taken: " + String.valueOf(duration) + "ms");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numFrequency = new HashMap<>();
        for (int i : nums) {
            if (numFrequency.keySet().contains(Integer.valueOf(i))) {
                numFrequency.put(Integer.valueOf(i), numFrequency.get(Integer.valueOf(i)) + Integer.valueOf(1));
            } else {
                numFrequency.put(Integer.valueOf(i), 1);
            }
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for (Integer key : numFrequency.keySet()) {
            queue.add(new Pair(key, numFrequency.get(key)));
        }

        int[] outArray = new int[k];
        for (int i = 0; i < k; i++) {
            outArray[i] = (int) (queue.poll().number);
        }

        return outArray;
    }

}

class Pair implements Comparable<Pair> {
    public Integer number;
    public Integer frequency;

    public Pair(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    public int compareTo(Pair other) {
        return Integer.compare(this.frequency, other.frequency) * Integer.valueOf(-1);
    }
}