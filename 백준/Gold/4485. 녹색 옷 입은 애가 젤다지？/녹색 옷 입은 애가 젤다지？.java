import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c, cost;
        Node(int r, int c, int cost) {
            this.r = r; this.c = c; this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            int N = Integer.parseInt(line.trim());
            if (N == 0) break;

            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) cave[i][j] = Integer.parseInt(st.nextToken());
            }

            sb.append("Problem ").append(tc++).append(": ").append(dijkstra(cave, N)).append('\n');
        }
        System.out.print(sb);
    }

    static int dijkstra(int[][] cave, int N) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        dist[0][0] = cave[0][0];
        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.r][cur.c]) continue; 

            if (cur.r == N - 1 && cur.c == N - 1) return cur.cost; 

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d], nc = cur.c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                int nextCost = cur.cost + cave[nr][nc];
                if (nextCost < dist[nr][nc]) {
                    dist[nr][nc] = nextCost;
                    pq.offer(new Node(nr, nc, nextCost));
                }
            }
        }
        return dist[N - 1][N - 1];
    }
}
