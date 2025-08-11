import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(Math.abs(a), Math.abs(b));
            return (cmp != 0) ? cmp : Integer.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            } else {
                pq.add(x);
            }
        }
        System.out.print(sb.toString());
    }
}
