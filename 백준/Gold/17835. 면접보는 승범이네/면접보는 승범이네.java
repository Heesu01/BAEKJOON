import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]>[] g = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            g[b].add(new int[]{a, t});
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int city = Integer.parseInt(st.nextToken());
            dist[city] = 0;
            pq.add(new long[]{city, 0});
        }

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int now = (int) cur[0];
            long d = cur[1];
            if (d > dist[now]) continue;

            for (int[] e : g[now]) {
                int nxt = e[0];
                long nd = d + e[1];
                if (nd < dist[nxt]) {
                    dist[nxt] = nd;
                    pq.add(new long[]{nxt, nd});
                }
            }
        }

        int ansCity = 1;
        long ansDist = dist[1];
        for (int i = 2; i <= N; i++) {
            if (dist[i] > ansDist) {
                ansDist = dist[i];
                ansCity = i;
            }
        }

        System.out.println(ansCity);
        System.out.println(ansDist);
    }
}
