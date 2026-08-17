# Java Arraylist

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Sometimes it's better to use dynamic size arrays. Java's  [Arraylist](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) can provide you this feature. Try to solve this problem using Arraylist.<br>

You are given $n$ lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in $y^{th}$ position of $x^{th}$ line. <br>

Take your input from System.in.

**Input Format**<br>
The first line has an integer $n$. In each of the next $n$ lines there will be an integer $d$ denoting number of integers on that line and then there will be $d$ space-separated integers. In the next line there will be an integer $q$ denoting number of queries. Each query will consist of two integers $x$ and $y$.

**Constraints**<br>

* $1<=n<=20000$
* $0<=d<=50000$
* $1<=q<=1000$
* $1<=x<=n$

Each number will fit in signed integer.<br>
Total number of integers in $n$ lines will not cross $10^5$.<br>

**Output Format**<br>
In each line, output the number  located in $y^{th}$ position of $x^{th}$ line. If there is no such position, just print "ERROR!"



**Input Format**

 

**Constraints**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T06:16:38.996Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt(); // Number of integers in this line
            ArrayList<Integer> line = new ArrayList<>();
            
            for (int j = 0; j < d; j++) {
                line.add(sc.nextInt());
            }
            lines.add(line);
        }
        
        int q = sc.nextInt();
        
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(); 
            int y = sc.nextInt(); 
            
            int lineIdx = x - 1;
            int elemIdx = y - 1;
            
            if (lineIdx >= 0 && lineIdx < lines.size() && elemIdx >= 0 && elemIdx < lines.get(lineIdx).size()) {
                System.out.println(lines.get(lineIdx).get(elemIdx));
            } else {
                System.out.println("ERROR!");
            }
        }
        
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-arraylist/problem)