import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        map = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    static int dfs(int y, int x) {
        if (dp[y][x] != 0) return dp[y][x];

        dp[y][x] = 1;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

            if (map[ny][nx] > map[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
            }
        }

        return dp[y][x];
    }
}
