# Find All Anagrams in a String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings `s` and `p`, return an array of all the start indices of `p`'s anagrams in `s`. You may return the answer in  **any order**.

 

 **Example 1:** 

```
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

```

 **Example 2:** 

```
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

```

 

 **Constraints:** 

- 1 <= s.length, p.length <= 3 * 104
- s and p consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 92.16%)  
**Memory:** 46.8 MB (beats 70.81%)  
**Submitted:** 2026-09-21T05:48:09.633Z  

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();  
        int n2 = p.length();  

        List<Integer> ans = new ArrayList<>();

        if (n1 < n2) return ans;

        int[] a = new int[26]; 
        int[] b = new int[26]; 

        for (int i = 0; i < n2; i++) {
            a[p.charAt(i) - 'a']++;
            b[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a, b)) {
            ans.add(0);
        }

        for (int i = n2; i < n1; i++) {
            b[s.charAt(i) - 'a']++;           
            b[s.charAt(i - n2) - 'a']--;     

            if (Arrays.equals(a, b)) {
                ans.add(i - n2 + 1);
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-all-anagrams-in-a-string/)