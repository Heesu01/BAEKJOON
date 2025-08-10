import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] g = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) g[i]=new ArrayList<>();
		
		for (int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		
		boolean[] v = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		v[1]=true;
		q.add(1);
		int cnt=0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt:g[cur]) {
				if(!v[nxt]) {
					v[nxt]=true;
					cnt++;
					q.add(nxt);
				}
			}
		}
	System.out.println(cnt);
	}
}
