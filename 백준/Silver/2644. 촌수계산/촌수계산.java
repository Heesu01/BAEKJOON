
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
    	
    	int m = Integer.parseInt(br.readLine());
    	
    	List<Integer>[] g = new ArrayList[n+1];
    	for (int i=1;i<n+1;i++) g[i] = new ArrayList<>();
    	
    	for(int i=0; i<m;i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		g[x].add(y);
    		g[y].add(x);
    	}

    	int[] dist = new int[n+1];
    	Arrays.fill(dist,-1);
    	dist[a]=0;

    	Queue<Integer> q = new LinkedList<>();
    	q.add(a);
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		for (int nxt:g[cur]) {
    			if (dist[nxt]!=-1) continue;
    			dist[nxt] = dist[cur]+1;
    			q.add(nxt);
    		}
    	}
    	
    	System.out.println(dist[b]);
    }
}
