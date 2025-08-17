import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            int layers = Math.min(N, M) / 2;
            for (int s = 0; s < layers; s++) {
                int top = s, left = s;
                int bottom = N - 1 - s, right = M - 1 - s;

                int start = arr[top][left];

                for (int c = left; c < right; c++) arr[top][c] = arr[top][c + 1];
                for (int i = top; i < bottom; i++) arr[i][right] = arr[i + 1][right];
                for (int c = right; c > left; c--) arr[bottom][c] = arr[bottom][c - 1];
                for (int i = bottom; i > top; i--) arr[i][left] = arr[i - 1][left];

                arr[top + 1][left] = start;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(arr[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
