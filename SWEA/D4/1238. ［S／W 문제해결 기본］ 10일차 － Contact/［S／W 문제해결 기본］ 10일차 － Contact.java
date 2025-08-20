import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {   
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len   = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());  

            List<Integer>[] g = new ArrayList[101];
            for (int i = 1; i <= 100; i++) g[i] = new ArrayList<>();
            
            
						st = new StringTokenizer(br.readLine());
						for (int i = 0; i < len/2; i++) {
						    int from = Integer.parseInt(st.nextToken());
						    int to   = Integer.parseInt(st.nextToken());
						    g[from].add(to);
						}
						

            boolean[] v = new boolean[101];
            Queue<Integer> q = new ArrayDeque<>();

            v[start] = true;
            q.add(start);

            int answer = start;  

            while (!q.isEmpty()) {
                int size = q.size();
                int levelMax = 0; 

                for (int i = 0; i < size; i++) {
                    int cur = q.poll();
                    levelMax = Math.max(levelMax, cur);

                    for (int nxt : g[cur]) {
                        if (!v[nxt]) {
                            v[nxt] = true;
                            q.add(nxt);
                        }
                    }
                }
                answer = levelMax;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
