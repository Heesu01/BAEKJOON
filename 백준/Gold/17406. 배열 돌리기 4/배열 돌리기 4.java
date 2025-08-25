import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] A;         
    static int[][] ops;       
    static boolean[] used;
    static int[] order;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][M + 1]; 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        ops = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            ops[i][0] = Integer.parseInt(st.nextToken());
            ops[i][1] = Integer.parseInt(st.nextToken());
            ops[i][2] = Integer.parseInt(st.nextToken());
        }

        used = new boolean[K];
        order = new int[K];
        permute(0);

        System.out.println(answer);
    }

    static void permute(int depth) {
        if (depth == K) {
            int[][] cur = copy(A);
            for (int idx = 0; idx < K; idx++) {
                int opIdx = order[idx];
                rotate(cur, ops[opIdx][0], ops[opIdx][1], ops[opIdx][2]);
            }
            answer = Math.min(answer, minRowSum(cur));
            return;
        }
        for (int i = 0; i < K; i++) {
            if (used[i]) continue;
            used[i] = true;
            order[depth] = i;
            permute(depth + 1);
            used[i] = false;
        }
    }

    static void rotate(int[][] arr, int r, int c, int s) {
        for (int t = 1; t <= s; t++) {
            int top = r - t, left = c - t, bottom = r + t, right = c + t;

            int temp = arr[top][left]; 

            for (int i = top; i < bottom; i++)
                arr[i][left] = arr[i + 1][left];

            for (int j = left; j < right; j++)
                arr[bottom][j] = arr[bottom][j + 1];

            for (int i = bottom; i > top; i--)
                arr[i][right] = arr[i - 1][right];

            for (int j = right; j > left + 1; j--)
                arr[top][j] = arr[top][j - 1];

            arr[top][left + 1] = temp;
        }
    }

    static int minRowSum(int[][] arr) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) sum += arr[i][j];
            res = Math.min(res, sum);
        }
        return res;
    }

    static int[][] copy(int[][] src) {
        int[][] dst = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) System.arraycopy(src[i], 1, dst[i], 1, M);
        return dst;
    }
}
