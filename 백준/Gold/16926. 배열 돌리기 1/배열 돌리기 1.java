import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        int layers = Math.min(N, M) / 2;
        for (int s = 0; s < layers; s++) {
            int top = s, left = s;
            int bottom = N - 1 - s, right = M - 1 - s;
            int h = bottom - top + 1, w = right - left + 1;
            int len = 2 * (h + w) - 4; 
            int[] ring = new int[len];

            int idx = 0;
            for (int c = left; c <= right; c++) ring[idx++] = A[top][c];              // 위 행 (→)
            for (int r = top + 1; r <= bottom; r++) ring[idx++] = A[r][right];        // 오른쪽 열 (↓)
            for (int c = right - 1; c >= left; c--) ring[idx++] = A[bottom][c];       // 아래 행 (←)
            for (int r = bottom - 1; r > top; r--) ring[idx++] = A[r][left];          // 왼쪽 열 (↑)

            int k = R % len;
            if (k == 0) continue;

            idx = 0;
            for (int c = left; c <= right; c++) A[top][c] = ring[(idx++ + k) % len];
            for (int r = top + 1; r <= bottom; r++) A[r][right] = ring[(idx++ + k) % len];
            for (int c = right - 1; c >= left; c--) A[bottom][c] = ring[(idx++ + k) % len];
            for (int r = bottom - 1; r > top; r--) A[r][left] = ring[(idx++ + k) % len];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(A[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
