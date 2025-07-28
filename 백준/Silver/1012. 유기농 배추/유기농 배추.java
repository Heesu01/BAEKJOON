import java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, K;
    static int[][] arr;
    static boolean[][] v;

    // 방향: 하, 우, 상, 좌
    static final int[] dy = { 1, 0, -1, 0 };
    static final int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); 
            N = Integer.parseInt(st.nextToken()); 
            K = Integer.parseInt(st.nextToken()); 

            arr = new int[N][M];
            v = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); 
                int y = Integer.parseInt(st.nextToken()); 
                arr[y][x] = 1;
            }

            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[y][x] == 1 && !v[y][x]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        v[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (arr[ny][nx] == 1 && !v[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
