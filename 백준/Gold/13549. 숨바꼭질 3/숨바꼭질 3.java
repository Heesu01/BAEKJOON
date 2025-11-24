import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, INF);
        dist[N] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, N});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int pos = cur[1];

            if (time > dist[pos]) continue;
            if (pos == K) break; 

            int next = pos * 2;
            if (next <= MAX && dist[next] > time) {
                dist[next] = time;
                pq.offer(new int[]{time, next});
            }

            next = pos - 1;
            if (next >= 0 && dist[next] > time + 1) {
                dist[next] = time + 1;
                pq.offer(new int[]{time + 1, next});
            }

            next = pos + 1;
            if (next <= MAX && dist[next] > time + 1) {
                dist[next] = time + 1;
                pq.offer(new int[]{time + 1, next});
            }
        }

        System.out.println(dist[K]);
    }
}
