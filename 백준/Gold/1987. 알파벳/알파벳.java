import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans = 0;
    static char[][] board;
    static boolean[] used = new boolean[26];
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < C; j++) board[i][j] = line.charAt(j);
        }

        // 시작 칸 사용 표시 후 DFS
        used[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(ans);
    }

    static void dfs(int x, int y, int len) {
        ans = Math.max(ans, len);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            int k = board[nx][ny] - 'A';
            if (used[k]) continue;

            used[k] = true;
            dfs(nx, ny, len + 1);
            used[k] = false;
        }
    }
}
