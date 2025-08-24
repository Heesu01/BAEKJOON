import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder out = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc=1;tc<T+1;tc++) {
    		int N = Integer.parseInt(br.readLine());
    		int M = Integer.parseInt(br.readLine());
    		
    		List<Integer>[] g = new ArrayList[N+1];
    		for(int i=1;i<N+1;i++) g[i]= new ArrayList<>();
    		
    		for (int i = 0; i < M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			g[a].add(b);
    		}
    		
    		boolean[][] reach = new boolean[N+1][N+1];
    		
    		for(int i=1;i<N+1;i++) {
    			boolean[] v = new boolean[N+1];
    			Deque<Integer> q = new ArrayDeque<>();
    			q.add(i);
    			
    			while(!q.isEmpty()) {
    				int cur = q.poll();
    				for(int nxt:g[cur]) {
    					if(v[nxt]) continue;
    					v[nxt]=true;
    					reach[i][nxt]=true;
    					q.add(nxt);
    				}
    			}
    		}
    		
    		int ans =0;
    		for (int i=1;i<N+1;i++) {
    			int smaller =0, bigger =0;
    			for (int j=1;j<N+1;j++) {
    				if (reach[i][j]) bigger++;
    				if (reach[j][i]) smaller++;
    			}
    			if (smaller + bigger == N-1) ans++;
    		}
    		
    		out.append("#").append(tc).append(" ").append(ans).append("\n");
    		
    	}
    	
    	
    	System.out.println(out);
    }
}
