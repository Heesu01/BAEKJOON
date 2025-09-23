import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dist; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, broken;
        Node(int x, int y, int broken) {
            this.x = x; this.y = y; this.broken = broken;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        dist = new int[N][M][2];
        int ans = bfs(0, 0);
        System.out.println(ans);
    }

    static int bfs(int sx, int sy) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sx, sy, 0));
        dist[sx][sy][0] = 1; 

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x, y = cur.y, b = cur.broken;

            if (x == N - 1 && y == M - 1) {
                return dist[x][y][b];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 0 && dist[nx][ny][b] == 0) {
                    dist[nx][ny][b] = dist[x][y][b] + 1;
                    q.offer(new Node(nx, ny, b));
                }

                if (map[nx][ny] == 1 && b == 0 && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = dist[x][y][0] + 1;
                    q.offer(new Node(nx, ny, 1));
                }
            }
        }
        return -1; 
    }
}
