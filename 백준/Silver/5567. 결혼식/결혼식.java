import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] g = new ArrayList[n+1];
		for(int i=1; i<=n; i++) g[i] = new ArrayList<>(); 
		
		for (int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		
		boolean[] v = new boolean[n+1];
		Queue<int[]> q = new LinkedList<>();
		
		v[1]=true;
		q.offer(new int[] {1,0});
		
		int cnt=0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int person = cur[0];
			int depth = cur[1];
			
			if(depth==2)continue;
			
			for(int friend: g[person]) {
				if(!v[friend]) {
					v[friend]=true;
					q.offer(new int[] {friend,depth+1});
					cnt++;
				}
			}
		}
	System.out.println(cnt);
		
	}

}
