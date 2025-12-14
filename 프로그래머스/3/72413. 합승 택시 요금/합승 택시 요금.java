import java.util.*;

class Solution {

    static final long INF = Long.MAX_VALUE / 4;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] f : fares) {
            int u = f[0], v = f[1], cost = f[2];
            graph[u].add(new int[]{v, cost});
            graph[v].add(new int[]{u, cost});
        }

        long[] distS = dijkstra(n, s, graph);
        long[] distA = dijkstra(n, a, graph);
        long[] distB = dijkstra(n, b, graph);

        long answer = INF;
        for (int k = 1; k <= n; k++) {
            long cost = distS[k] + distA[k] + distB[k];
            if (cost < answer) answer = cost;
        }

        return (int) answer;
    }

    private long[] dijkstra(int n, int start, List<int[]>[] graph) {

        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.add(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int now = (int) cur[0];
            long nowCost = cur[1];

            if (nowCost > dist[now]) continue;

            for (int[] edge : graph[now]) {
                int next = edge[0];
                int w = edge[1];
                long newCost = nowCost + w;

                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new long[]{next, newCost});
                }
            }
        }

        return dist;
    }
}
