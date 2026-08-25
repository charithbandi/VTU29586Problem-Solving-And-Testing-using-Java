# Multiply 2 Matrices

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two square matrices  **mat1[][]**  and  **mat2[][]**, each of size  **n × n**. Multiply these two matrices and return the resulting matrix.

 **Examples:** 

```
Input: mat1[][] = [[1, 1, 1], [1, 1, 1], [1, 1, 1]], mat2[][] = [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
Output: [[3, 3, 3], [3, 3, 3], [3, 3, 3]]
Explanation: After multiplying mat1 and mat2 we get the resulting matrix equal to [[3, 3, 3], [3, 3, 3], [3, 3, 3]].
```

```
Input: mat1[][] = [[1, 2], [3, 4]], mat2[][] = [[4, 3], [2, 1]]
Output: [[8, 5], [20, 13]]
Explanation: After multiplying mat1 and mat2 we get the resulting matrix equal to [[8, 5], [20, 13]]
```

 **Constraints:** 
1 ≤ n ≤ 100
1 ≤ mat1[i][j], mat2[i][j] ≤ 100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-24T06:31:07.193Z  

```java
import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Multiply the two matrices
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += mat1[i][k] * mat2[k][j];
                }
                row.add(sum);
            }
            res.add(row);
        }

        return res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/multiply-2-matrices4144/1)