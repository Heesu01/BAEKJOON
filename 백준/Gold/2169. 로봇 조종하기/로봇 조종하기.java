import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][M+1];
        
        dp[1][1] = a[1][1];
        for (int j = 2; j <= M; j++) dp[1][j] = dp[1][j-1] + a[1][j];

        int[] L = new int[M+1];
        int[] R = new int[M+2];

        for (int i = 2; i <= N; i++) {
            
            L[1] = dp[i-1][1] + a[i][1];
            for (int j = 2; j <= M; j++) {
                L[j] = Math.max(L[j-1], dp[i-1][j]) + a[i][j];
            }
            
            R[M] = dp[i-1][M] + a[i][M];
            for (int j = M-1; j >= 1; j--) {
                R[j] = Math.max(R[j+1], dp[i-1][j]) + a[i][j];
            }
            
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(L[j], R[j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
