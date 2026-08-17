
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add current element to the window
            deque.addLast(num);
            set.add(num);
            
            // Once the window size reaches M
            if (deque.size() == m) {
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }
                
                // If maximum possible unique numbers is reached, we can stop early
                if (maxUnique == m) {
                    System.out.println(m);
                    return;
                }
                
                // Slide the window: remove the oldest element
                int first = deque.removeFirst();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        
        System.out.println(maxUnique);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-dequeue/problem)
