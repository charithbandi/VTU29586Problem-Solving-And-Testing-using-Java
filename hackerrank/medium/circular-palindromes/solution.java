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
