import java.io.*;
import java.util.*;


public class Solution{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] V = new int[N+1];
			int[] C = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				V[i]= Integer.parseInt(st.nextToken());
				C[i]= Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[N+1][K+1];
			
			for (int i=1;i<=N;i++) {
				for (int w=1;w<=K;w++) {
					dp[i][w]= dp[i-1][w];
					if(w>=V[i]) {
						dp[i][w] = Math.max(dp[i][w], dp[i-1][w-V[i]]+C[i]);
					}	
				}
			}
			
		sb.append("#").append(tc).append(" ").append(dp[N][K]).append('\n');
		}
		
		System.out.print(sb);
	}
	
}