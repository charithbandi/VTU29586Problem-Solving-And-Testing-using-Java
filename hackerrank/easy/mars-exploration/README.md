# Mars Exploration

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

A space explorer's ship crashed on Mars! They send a series of `SOS` messages to Earth for help. 

<img src="https://s3.amazonaws.com/hr-challenge-images/16032/1453204202-9e3fd295bb-NASA_Mars_Rover.jpg" title="NASA_Mars_Rover.jpg" />

Letters in some of the `SOS` messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, $s$, determine how many letters of the `SOS` message have been changed by radiation.

**Example**  

$s = \text{'SOSTOT'}$  

The original message was `SOSSOS`.  Two of the message's characters were changed in transit.  

**Function Description**

Complete the *marsExploration* function in the editor below.  

marsExploration has the following parameter(s):

- *string s:* the string as received on Earth  

**Returns**  

- *int:* the number of letters changed during transmission  

**Input Format**

There is one line of input: a single string, $s$. 


**Constraints**

* $1 \le \text{ length of }s \le 99$
* $ \text{ length of }s \text{ modulo } \ 3=0$
* $s$ will contain only uppercase English letters, ascii[A-Z].

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T05:43:23.608Z  

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        int count = 0;
        String sos = "SOS";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos.charAt(i % 3)) {
                count++;
            }
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/mars-exploration/problem)