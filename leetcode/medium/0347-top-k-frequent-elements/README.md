# Top K Frequent Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the*  `k`  *most frequent elements*. You may return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  nums = [1,1,1,2,2,3], k = 2

 **Output:**  [1,2]

 **Example 2:** 

 **Input:**  nums = [1], k = 1

 **Output:**  [1]

 **Example 3:** 

 **Input:**  nums = [1,2,1,2,1,2,3,1,3,2], k = 2

 **Output:**  [1,2]

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104
- k is in the range [1, the number of unique elements in the array].
- It is guaranteed that the answer is unique.

 

 **Follow up:**  Your algorithm's time complexity must be better than `O(n log n)`, where n is the array's size.

## Solution

**Language:** Java  
**Runtime:** 14 ms (beats 70.72%)  
**Memory:** 47.5 MB (beats 82.81%)  
**Submitted:** 2026-08-10T05:51:31.035Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/top-k-frequent-elements/)