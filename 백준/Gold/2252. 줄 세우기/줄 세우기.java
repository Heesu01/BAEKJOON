import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] g = new ArrayList[N+1];
		for(int i=1;i<=N;i++) g[i]= new ArrayList<>();
		
		int[] indegree = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g[A].add(B);
			indegree[B]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int nxt: g[cur]) {
				indegree[nxt]--;
				if(indegree[nxt]==0) q.add(nxt);
			}
		}
		System.out.println(sb);
    }
}
