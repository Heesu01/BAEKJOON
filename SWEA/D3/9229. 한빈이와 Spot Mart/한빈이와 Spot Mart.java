import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 

            int[] snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int sum = snack[i] + snack[j];
                    if (sum <= M) {
                        max = Math.max(max, sum);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
