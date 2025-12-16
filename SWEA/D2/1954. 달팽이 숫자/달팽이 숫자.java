import java.io.*;
import java.util.StringTokenizer;

class Solution {
    static int[] dr = {0, 1, 0, -1}; // 우하좌상
    static int[] dc = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
            
            int r = 0, c = 0;
            int d = 0; // 방향
            int w = 1; // 채워넣을 숫자
            snail[0][0] = 1;

            while (w < N * N) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                // 범위 내이고 아직 방문하지 않은 곳이라면
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && snail[nr][nc] == 0) {
                    snail[nr][nc] = ++w;
                    r = nr;
                    c = nc;
                } else {
                    // 방향 전환
                    d = (d + 1) % 4;
                }
            }

            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}