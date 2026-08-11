# Largest Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a list of non-negative integers `nums`, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

 **Example 1:** 

```
Input: nums = [10,2]
Output: "210"

```

 **Example 2:** 

```
Input: nums = [3,30,34,5,9]
Output: "9534330"

```

 

 **Constraints:** 

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 94.69%)  
**Memory:** 45.2 MB (beats 29.57%)  
**Submitted:** 2026-08-11T06:19:18.086Z  

```java
class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        // Convert to strings once.
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Core comparator:
        // a comes before b if (a+b) is lexicographically larger than (b+a).
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // All-zero case.
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/largest-number/)