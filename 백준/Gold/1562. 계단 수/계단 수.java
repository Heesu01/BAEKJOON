import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][][] dp = new int[N + 1][10][1 << 10];

        for (int d = 1; d <= 9; d++) {
            int mask = 1 << d;  
            dp[1][d][mask] = 1; 
        }

        for (int len = 1; len < N; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int mask = 0; mask < (1 << 10); mask++) { 

                    int cur = dp[len][digit][mask];
                    if (cur == 0) continue; 

                    if (digit > 0) {
                        int nd = digit - 1; 
                        int nmask = mask | (1 << nd); 
                        dp[len + 1][nd][nmask] =
                                (dp[len + 1][nd][nmask] + cur) % MOD;
                    }

                    if (digit < 9) {
                        int nd = digit + 1;
                        int nmask = mask | (1 << nd);
                        dp[len + 1][nd][nmask] =
                                (dp[len + 1][nd][nmask] + cur) % MOD;
                    }
                }
            }
        }

        int FULL = (1 << 10) - 1; 
        
        long ans = 0;

        for (int digit = 0; digit <= 9; digit++) {
            ans = (ans + dp[N][digit][FULL]) % MOD;
        }

        System.out.println(ans);
    }
}
