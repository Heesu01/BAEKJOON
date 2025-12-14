import java.util.*;

class Solution {
    static class Edge {
        int to;
        int w;
        Edge(int t, int w) {
            this.to = t;
            this.w = w;
        }
    }

    static final long INF = Long.MAX_VALUE / 4;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 인접 리스트
        List<Edge>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] f : fares) {
            int u = f[0], v = f[1], w = f[2];
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }

        long[] distS = dijkstra(n, s, g);
        long[] distA = dijkstra(n, a, g);
        long[] distB = dijkstra(n, b, g);

        long ans = INF;
        for (int k = 1; k <= n; k++) {
            if (distS[k] == INF || distA[k] == INF || distB[k] == INF) continue;
            long cost = distS[k] + distA[k] + distB[k];
            if (cost < ans) ans = cost;
        }

        return (int) ans;
    }

    private long[] dijkstra(int n, int start, List<Edge>[] g) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.add(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int x = (int) cur[0];
            long d = cur[1];

            if (d > dist[x]) continue;

            for (Edge e : g[x]) {
                int nx = e.to;
                long nd = d + e.w;
                if (nd < dist[nx]) {
                    dist[nx] = nd;
                    pq.add(new long[]{nx, nd});
                }
            }
        }
        return dist;
    }
}
