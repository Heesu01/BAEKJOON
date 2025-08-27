import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] T, P;
	static int ans=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
	    T = new int[N + 1];
	    P = new int[N + 1];
		
		for(int i=1;i<N+1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}
		dfs(1,0);
		sb = sb.append(ans);
		System.out.println(sb.toString());
    }
	
	static void dfs(int day, int gain) {
		if (day ==N+1) {
			ans = Math.max(ans,  gain);
			return;
		}
		if(day>N+1) {
			return;
		}
		dfs(day+1,gain);
		
		if(day+T[day]<=N+1) {
			dfs(day+T[day], gain + P[day]);
		}
	}
	
}
