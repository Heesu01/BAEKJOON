import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[N + 1];
        List<int[]>[] reverse = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, cost});
            reverse[to].add(new int[]{from, cost});
        }

        int[] distGo = dijkstra(graph, X, N);

        int[] distBack = dijkstra(reverse, X, N);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distGo[i] == Integer.MAX_VALUE || distBack[i] == Integer.MAX_VALUE) continue;
            answer = Math.max(answer, distGo[i] + distBack[i]);
        }

        System.out.println(answer);
    }

    static int[] dijkstra(List<int[]>[] g, int start, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] next : g[now]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist;
    }
}
