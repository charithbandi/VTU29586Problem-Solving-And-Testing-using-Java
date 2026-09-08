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
     * Complete the 'stringSimilarity' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

   public static long stringSimilarity(String s) {
    int n = s.length();
    char[] str = s.toCharArray();
    int[] z = new int[n];
    long totalSimilarity = n; // The string's similarity with itself is its full length
    
    int l = 0, r = 0;
    for (int i = 1; i < n; i++) {
        // If i is within the current window, initialize z[i] using previously computed values
        if (i <= r) {
            z[i] = Math.min(r - i + 1, z[i - l]);
        }
        // Expand the window to the right as long as characters match the prefix
        while (i + z[i] < n && str[z[i]] == str[i + z[i]]) {
            z[i]++;
        }
        // Update the window [l, r] if we found a new rightmost boundary
        if (i + z[i] - 1 > r) {
            l = i;
            r = i + z[i] - 1;
        }
        
        totalSimilarity += z[i];
    }
    
    return totalSimilarity;
}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

               long result = Result.stringSimilarity(s);
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
