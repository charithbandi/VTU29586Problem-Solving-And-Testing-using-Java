import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static boolean isLapindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];

        // Increment counts for first half, decrement for second half
        for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[s.charAt(n - 1 - i) - 'a']--;
        }

        // Check if all character counts balance to zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        if (line == null) return;
        
        st = new StringTokenizer(line);
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String s = br.readLine().trim();
            if (isLapindrome(s)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
}
