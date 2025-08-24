import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	List<Integer>[] g = new ArrayList[N+1];
    	for(int i=1;i<N+1;i++) g[i]=new ArrayList<>();
    	int[] indeg = new int[N + 1];
    	
    	for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	g[A].add(B);
        	indeg[B]++;
    	}
    	
    	int[] ans = new int[N+1];
    	Arrays.fill(ans, 1);
    	
    	Deque<Integer> q = new ArrayDeque<>();
    	for (int i = 1; i <= N; i++) if (indeg[i] == 0) q.add(i);
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		for (int nxt: g[cur]) {
                if (ans[nxt] < ans[cur] + 1) ans[nxt] = ans[cur] + 1;
                if (--indeg[nxt] == 0) q.add(nxt);
    		}
    	}
    	for (int i = 1; i <= N; i++) sb.append(ans[i]).append(' ');
    	System.out.println(sb.toString());
    }
}
