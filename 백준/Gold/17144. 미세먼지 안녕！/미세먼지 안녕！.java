import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] A;
    static int up = -1, down = -1;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        A = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1) {
                    if (up == -1) up = i;
                    else down = i;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spreadDust();
            cleanUpperAir();
            cleanLowerAir();
        }

        System.out.println(getTotalDust());
    }

    static void spreadDust() {
        int[][] tmp = new int[R][C];
        tmp[up][0] = -1;
        tmp[down][0] = -1;

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (A[x][y] <= 0) continue;
                int dust = A[x][y];
                int spread = dust / 5;
                if (spread == 0) {
                    tmp[x][y] += dust;
                    continue;
                }

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (A[nx][ny] == -1) continue;
                    tmp[nx][ny] += spread;
                    cnt++;
                }
                tmp[x][y] += dust - spread * cnt;
            }
        }
        A = tmp;
    }

    static void cleanUpperAir() {
        for (int r = up - 1; r > 0; r--) A[r][0] = A[r - 1][0];
        for (int c = 0; c < C - 1; c++) A[0][c] = A[0][c + 1];
        for (int r = 0; r < up; r++) A[r][C - 1] = A[r + 1][C - 1];
        for (int c = C - 1; c > 1; c--) A[up][c] = A[up][c - 1];
        A[up][1] = 0;
        A[up][0] = -1;
    }

    static void cleanLowerAir() {
        for (int r = down + 1; r < R - 1; r++) A[r][0] = A[r + 1][0];
        for (int c = 0; c < C - 1; c++) A[R - 1][c] = A[R - 1][c + 1];
        for (int r = R - 1; r > down; r--) A[r][C - 1] = A[r - 1][C - 1];
        for (int c = C - 1; c > 1; c--) A[down][c] = A[down][c - 1];
        A[down][1] = 0;
        A[down][0] = -1;
    }

    static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) sum += A[i][j];
            }
        }
        return sum;
    }
}
