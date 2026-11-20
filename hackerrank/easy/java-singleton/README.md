# Java Singleton Pattern

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

> "The singleton pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system."	
> - [Wikipedia: Singleton Pattern](https://en.wikipedia.org/wiki/Singleton_pattern)
***

Complete the *Singleton* class in your editor which contains the following components:  


1. A *private Singleton* non parameterized constructor.
2. A *public* String instance variable named $str$. 
3. Write a *static* method named *getSingleInstance* that returns the single instance of the *Singleton* class.

Once submitted, our hidden *Solution* class will check your code by taking a String as input and then using your *Singleton* class to print a line.

**Input Format**

You will not be handling any input in this challenge. 

**Constraints**

 

**Output Format**

You will not be producing any output in this challenge.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-20T16:28:14.192Z  

```java
import java.io.*;
import java.util.*;

class Singleton {
    private static Singleton instance = null;
    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        Singleton singleton = Singleton.getSingleInstance();
        singleton.str = s;
        
        System.out.println("Hello I am a singleton! Let me say " + singleton.str + " to you");
        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-singleton/problem)