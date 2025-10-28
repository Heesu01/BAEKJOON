import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine()); 

        List<int[]>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] next : graph[now]) {
                int nxt = next[0];
                int newCost = cost + next[1];

                if (newCost < dist[nxt]) {
                    dist[nxt] = newCost;
                    pq.add(new int[]{nxt, newCost});
                }
            }
        }
				
				for (int i = 1; i <= V; i++) {
				    if (dist[i] == Integer.MAX_VALUE) {
				        sb.append("INF\n");
				    } else {
				        sb.append(dist[i]).append('\n');
				    }
				}


        System.out.print(sb);
    }
}
