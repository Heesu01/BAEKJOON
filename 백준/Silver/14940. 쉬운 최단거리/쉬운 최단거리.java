import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        int sx = -1, sy = -1;   // 시작점(2)

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;               // 일단 전부 -1
                if (map[i][j] == 2) {          // 시작 위치 찾기
                    sx = i;
                    sy = j;
                }
                if (map[i][j] == 0) {
                    dist[i][j] = 0;            // 0은 무조건 0으로 출력해야 함
                }
            }
        }

        // BFS
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 밖
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 갈 수 없는 곳(0) 이면 패스 (이미 dist=0으로 세팅됨)
                if (map[nx][ny] == 0) continue;
                // 이미 방문한 곳이면 패스
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
