# Java Date and Time

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

The [Calendar class](https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html) is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.
***

You are given a date. You just need to write the method, $getDay$, which returns the *day* on that date.  To simplify your task, we have provided a portion of the code in the editor. 

**Example**   
$month = 8$   
$day = 14$    
$year = 2017$   

The method should return $MONDAY$ as the day on that date. 

![image](https://s3.amazonaws.com/hr-assets/0/1514458312-c097047ed4-calendar_class.png)  

**Function Description**   

Complete the *findDay* function in the editor below.   

*findDay* has the following parameters:   

- *int:* month   
- *int:* day   
- *int:* year   

**Returns**   

- *string:* the day of the week in capital letters   

**Input Format**

A single line of input containing the space separated month, day and year, respectively, in $MM$ $DD$ $YYYY$ format.




**Constraints**

* $ 2000 < year < 3000 $

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-10T06:32:57.686Z  

```java


class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        
        // Calendar months are 0-indexed (January is 0, August is 7)
        cal.set(year, month - 1, day);
        
        int dayOfWeekIndex = cal.get(Calendar.DAY_OF_WEEK);
        
        String[] days = new DateFormatSymbols(Locale.US).getWeekdays();
        
        return days[dayOfWeekIndex].toUpperCase();

    }

}


```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-date-and-time/problem)