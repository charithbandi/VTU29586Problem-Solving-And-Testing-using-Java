# Java Dequeue

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added  to or removed from either the front (head) or back (tail).

    
Deque interfaces can be implemented using various types of collections such as `LinkedList` or `ArrayDeque` classes. For example, deque can be declared as:

    Deque deque = new LinkedList<>();
    or
    Deque deque = new ArrayDeque<>();
    
You can find more details about Deque [here](http://docs.oracle.com/javase/7/docs/api/java/util/Deque.html).

In this problem, you are given $N$ integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size $M$.

*Note*: Time limit is $3$ second for this problem.


**Input Format**

The first line of input contains two integers $N$ and $M$: representing the total number of integers and the size of the subarray, respectively. The next line contains $N$ space separated integers. 

**Constraints**

$1 \le N \le 100000$<br>
$1 \le M \le 100000$<br>
$M\le N$<br>
The numbers in the array will range between $[0,10000000]$.


**Output Format**

Print the *maximum* number of unique integers among all possible contiguous subarrays of size $M$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-10T05:58:59.593Z  

```java
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add current element to the window
            deque.addLast(num);
            set.add(num);
            
            // Once the window size reaches M
            if (deque.size() == m) {
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }
                
                // If maximum possible unique numbers is reached, we can stop early
                if (maxUnique == m) {
                    System.out.println(m);
                    return;
                }
                
                // Slide the window: remove the oldest element
                int first = deque.removeFirst();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        
        System.out.println(maxUnique);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-dequeue/problem)