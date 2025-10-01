import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] g;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        parent = new int[N + 1];
        visited = new boolean[N + 1];

        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true; 
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    parent[nxt] = cur; 
                    q.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) sb.append(parent[i]).append('\n');
        System.out.print(sb.toString());
    }
}
