# Day of the Year

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `date` representing a Gregorian calendar date formatted as `YYYY-MM-DD`, return  *the day number of the year*.

 

 **Example 1:** 

```
Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

```

 **Example 2:** 

```
Input: date = "2019-02-10"
Output: 41

```

 

 **Constraints:** 

- date.length == 10
- date[4] == date[7] == '-', and all other date[i]'s are digits
- date represents a calendar date between Jan 1st, 1900 and Dec 31st, 2019.

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 97.06%)  
**Memory:** 46.8 MB (beats 92.83%)  
**Submitted:** 2026-08-10T06:50:08.263Z  

```java
class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Leap year check: divisible by 4 and not 100, unless divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysPerMonth[1] = 29;
        }

        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysPerMonth[i];
        }

        return dayOfYear;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/day-of-the-year/)