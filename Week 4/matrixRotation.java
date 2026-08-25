import java.io.*;
import java.util.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numRings = Math.min(m, n) / 2;

        for (int k = 0; k < numRings; k++) {
            List<Integer> ring = new ArrayList<>();
            
            // 1. Extract the current ring/layer
            // Top row
            for (int j = k; j < n - k; j++) {
                ring.add(matrix.get(k).get(j));
            }
            // Right column
            for (int i = k + 1; i < m - k; i++) {
                ring.add(matrix.get(i).get(n - 1 - k));
            }
            // Bottom row
            for (int j = n - 2 - k; j >= k; j--) {
                ring.add(matrix.get(m - 1 - k).get(j));
            }
            // Left column
            for (int i = m - 2 - k; i > k; i--) {
                ring.add(matrix.get(i).get(k));
            }

            // 2. Rotate the elements and put them back
            int len = ring.size();
            int rot = r % len; 
            int idx = rot;
            
            // Top row
            for (int j = k; j < n - k; j++) {
                matrix.get(k).set(j, ring.get(idx % len));
                idx++;
            }
            // Right column
            for (int i = k + 1; i < m - k; i++) {
                matrix.get(i).set(n - 1 - k, ring.get(idx % len));
                idx++;
            }
            // Bottom row
            for (int j = n - 2 - k; j >= k; j--) {
                matrix.get(m - 1 - k).set(j, ring.get(idx % len));
                idx++;
            }
            // Left column
            for (int i = m - 2 - k; i > k; i--) {
                matrix.get(i).set(k, ring.get(idx % len));
                idx++;
            }
        }

        // 3. Print the rotated matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }
            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
