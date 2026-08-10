import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count element frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        List<Integer>[] freqSorted = new List[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            if (freqSorted[freq] == null) {
                freqSorted[freq] = new ArrayList<>();
            }
            freqSorted[freq].add(key);
        }

        // Step 3: Gather the top k frequent elements from right to left
        List<Integer> res = new ArrayList<>();
        for (int i = freqSorted.length - 1; i >= 0 && res.size() < k; i--) {
            if (freqSorted[i] != null) {
                res.addAll(freqSorted[i]);
            }
        }

        // Convert List<Integer> to int[]
        return res.stream().mapToInt(i -> i).toArray();
    }
}
