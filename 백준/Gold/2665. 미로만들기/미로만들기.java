import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map, dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0'; 
                dist[i][j] = INF;
            }
        }

        zeroOneBfs();
        System.out.println(dist[n - 1][n - 1]);
    }

    static void zeroOneBfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int w;
                if (map[nx][ny] == 1) {
                    w = 0; 
                } else {
                    w = 1; 
                }

                if (dist[nx][ny] > dist[x][y] + w) {
                    dist[nx][ny] = dist[x][y] + w;
                    if (w == 0) {
                        dq.addFirst(new int[]{nx, ny}); 
                    } else {
                        dq.addLast(new int[]{nx, ny});  
                    }
                }
            }
        }
    }
}
