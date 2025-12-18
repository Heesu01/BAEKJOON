import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] dp = new int[K + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				for (int j = K; j - v >= 0; j--) {
					dp[j] = Math.max(dp[j], dp[j - v] + c);
				}
			}
			
			sb.append("#").append(t).append(" ").append(dp[K]).append("\n");
		}
		
		System.out.println(sb);
	}
}
