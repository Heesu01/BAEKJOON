import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> viruses = new ArrayList<>();
    static int emptyCount; 
    static int answer = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) viruses.add(new int[]{i, j});
                else if (map[i][j] == 0) emptyCount++;
            }
        }

        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }

        choose(0, 0, new int[M]);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void choose(int idx, int start, int[] picked) {
        if (idx == M) {
            bfs(picked);
            return;
        }
        for (int i = start; i < viruses.size(); i++) {
            picked[idx] = i;
            choose(idx + 1, i + 1, picked);
        }
    }

    static void bfs(int[] picked) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int idx : picked) {
            int[] v = viruses.get(idx);
            q.add(new int[]{v[0], v[1]});
            dist[v[0]][v[1]] = 0; 
        }

        int remain = emptyCount;
        int time = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1) continue; 
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});

                if (map[nx][ny] == 0) {
                    remain--;
                    time = dist[nx][ny];
                    if (remain == 0) { 
                        answer = Math.min(answer, time);
                        return;
                    }
                }
            }
        }
    }
}
