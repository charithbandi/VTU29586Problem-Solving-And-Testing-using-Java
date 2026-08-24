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
