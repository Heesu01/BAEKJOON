import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] board;
    static boolean[][][] visited;
    static final int[] dx4 = {-1, 1, 0, 0};
    static final int[] dy4 = {0, 0, -1, 1};
    static final int[] hx  = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] hy  = {-1,  1, -2,  2,-2, 2,-1, 1};

    static class Node {
        int x, y, used, dist;
        Node(int x, int y, int used, int dist) {
            this.x = x; this.y = y; this.used = used; this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    static int bfs() {
        visited = new boolean[H][W][K + 1];
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[0][0][0] = true;
        q.add(new Node(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == H - 1 && cur.y == W - 1) return cur.dist;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx4[d], ny = cur.y + dy4[d];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (board[nx][ny] == 1) continue;
                if (!visited[nx][ny][cur.used]) {
                    visited[nx][ny][cur.used] = true;
                    q.add(new Node(nx, ny, cur.used, cur.dist + 1));
                }
            }

            if (cur.used < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + hx[d], ny = cur.y + hy[d];
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if (board[nx][ny] == 1) continue;
                    if (!visited[nx][ny][cur.used + 1]) {
                        visited[nx][ny][cur.used + 1] = true;
                        q.add(new Node(nx, ny, cur.used + 1, cur.dist + 1));
                    }
                }
            }
        }
        return -1; 
    }
}
