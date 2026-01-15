import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<int[]>[] g = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < D; i++) {
            g[i].add(new int[]{i + 1, 1});
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (start > D || end > D) continue;
            if (cost >= end - start) continue;

            g[start].add(new int[]{end, cost});
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int v = cur[1];

            for (int[] edge : g[v]) {
                int nv = edge[0];
                int w = edge[1];

                int nd = d + w;
                if (nd < dist[nv]) {
                    dist[nv] = nd;
                    pq.add(new int[]{nd, nv});
                }
            }
        }

        System.out.println(dist[D]);
    }
}
