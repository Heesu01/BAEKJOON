
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] g = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) g[i]=new ArrayList<>();
		for (int i=0;i<M;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st1.nextToken());
			int v = Integer.parseInt(st1.nextToken());
			g[u].add(v);
			g[v].add(u);
		}
		
		boolean[] v = new boolean[N+1];
		int cnt =0;
		for (int i=1;i<N+1;i++) {
			if(!v[i]) {
				Queue<Integer> q = new LinkedList<>();
				v[i]=true;
				q.add(i);
				
				while(!q.isEmpty()){
					int cur = q.poll();
					for (int nxt:g[cur]) {
						if(!v[nxt]) {
							v[nxt]=true;
							q.add(nxt);
						}
					}
				}
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
