# Day of the Week

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the `day`, `month` and `year` respectively.

Return the answer as one of the following values `{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}`.

 **Note:**  January 1, 1971 was a Friday.

 

 **Example 1:** 

```
Input: day = 31, month = 8, year = 2019
Output: "Saturday"

```

 **Example 2:** 

```
Input: day = 18, month = 7, year = 1999
Output: "Sunday"

```

 **Example 3:** 

```
Input: day = 15, month = 8, year = 1993
Output: "Sunday"

```

 

 **Constraints:** 

- The given dates are valid dates between the years 1971 and 2100.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.4 MB (beats 69.68%)  
**Submitted:** 2026-08-10T06:52:04.559Z  

```java
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int[] daysInMonth = {
            31,28,31,30,31,30,31,31,30,31,30,31
        };

        int totalDays = 0;

        // Count days for complete years
        for (int y = 1971; y < year; y++) {
            totalDays += isLeap(y) ? 366 : 365;
        }

        // Count days for complete months
        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];

            if (m == 2 && isLeap(year)) {
                totalDays++;
            }
        }

        // Count days in current month
        totalDays += day - 1;

        // January 1, 1971 was Friday
        return week[(5 + totalDays) % 7];
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/day-of-the-week/)