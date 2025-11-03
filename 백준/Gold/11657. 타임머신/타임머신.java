import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static long[] dist;
    static int[][] edges; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new int[M][3]; 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()); 
            edges[i][1] = Integer.parseInt(st.nextToken()); 
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; 
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int from = edges[j][0];
                int to = edges[j][1];
                int cost = edges[j][2];
                if (dist[from] != INF && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            int from = edges[j][0];
            int to = edges[j][1];
            int cost = edges[j][2];
            if (dist[from] != INF && dist[to] > dist[from] + cost) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dist[i] == INF) sb.append(-1).append('\n');
            else sb.append(dist[i]).append('\n');
        }
        System.out.print(sb);
    }
}
