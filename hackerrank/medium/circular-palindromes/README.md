# Circular Palindromes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A *palindrome* is a string that reads the same from left to right as it does from right to left.

Given a string, $S$, of $N$ lowercase English letters, we define a *$k$-length rotation* as cutting the first $k$ characters from the beginning of $S$ and appending them to the end of $S$. For each $S$, there are $N$ possible $k$-length rotations (where $0 \le k \lt N$). See the *Explanation* section for examples.

Given $N$ and $S$, find all $N$ $k$-length rotations of $S$; for each rotated string, $S_k$, print the maximum possible length of any palindromic substring of $S_k$ on a new line.

**Input Format**

The first line contains an integer, $N$ (the length of $S$).	
The second line contains a single string, $S$.

**Constraints**

- $1 \le N \le 5 \times 10^5$
- $0 \le k \lt N$
- $\textit{S is comprised of lowercase English letters.}$

**Output Format**

There should be $N$ lines of output, where each line $k$ contains an integer denoting the maximum length of any palindromic substring of rotation $S_k$.

**Sample Input 0**

    13
    aaaaabbbbaaaa
    
**Sample Output 0**

    12
    12
    10
    8
    8
    9
    11
    13
    11
    9
    8
    8
    10

**Sample Input 1**

    7
    cacbbba
    
**Sample Output 1**

    3
    3
    3
    3
    3
    3
    3


**Sample Input 2**

    12
    eededdeedede

**Sample Output 2**

    5
    7
    7
    7
    7
    9
    9
    9
    9
    7
    5
    4

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T06:08:24.865Z  

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    public static List<Integer> circularPalindromes(String s) {
        int n = s.length();
        if (n == 0) return new ArrayList<>();

        String doubled = s + s;

        List<Integer> result = new ArrayList<>(n);
        for (int k = 0; k < n; k++) {
            String sub = doubled.substring(k, k + n);
            result.add(maxPalindromeLength(sub));
        }
        return result;
    }

    private static int maxPalindromeLength(String str) {
        int n = str.length();
        if (n == 0) return 0;

        // Build transformed string for Manacher's Algorithm
        char[] t = new char[2 * n + 3];
        t[0] = '^';
        for (int i = 0; i < n; i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = str.charAt(i);
        }
        t[2 * n + 1] = '#';
        t[2 * n + 2] = '$';

        int tLen = t.length;
        int[] p = new int[tLen];
        int center = 0, right = 0;
        int maxLen = 0;

        for (int i = 1; i < tLen - 1; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (p[i] > maxLen) {
                maxLen = p[i];
            }
        }
        return maxLen;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/circular-palindromes/problem)