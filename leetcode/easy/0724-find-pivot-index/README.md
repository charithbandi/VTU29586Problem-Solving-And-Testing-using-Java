# Find Pivot Index

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of integers `nums`, calculate the  **pivot index**  of this array.

The  **pivot index**  is the index where the sum of all the numbers  **strictly**  to the left of the index is equal to the sum of all the numbers  **strictly**  to the index's right.

If the index is on the left edge of the array, then the left sum is `0` because there are no elements to the left. This also applies to the right edge of the array.

Return  *the  **leftmost pivot index***. If no such index exists, return `-1`.

 

 **Example 1:** 

```
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

```

 **Example 2:** 

```
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
```

 **Example 3:** 

```
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -1000 <= nums[i] <= 1000

 

 **Note:**  This question is the same as 1991: https://leetcode.com/problems/find-the-middle-index-in-array/

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 97.44%)  
**Memory:** 47.6 MB (beats 8.99%)  
**Submitted:** 2026-08-03T06:44:12.548Z  

```java
class Solution {
    public int pivotIndex(int[] arr) {
        int[] pre = new int[arr.length];

        pre[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        int[] sufFixArr = suffix(arr);

        int min = Math.min(pre.length, sufFixArr.length);

        for (int i = 0; i < min; i++) {
            if (pre[i] == sufFixArr[i]) {
                if (i == 0) {
                    return 0;
                }
                return i;
            }
        }

        return -1;
    }

    public int[] suffix(int[] arr) {

        int[] suff = new int[arr.length];

        suff[arr.length - 1] = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + arr[i + 1];
            ;
        }

        return suff;
    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/find-pivot-index/)