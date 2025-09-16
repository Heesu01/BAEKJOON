import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] g;
    static int[] parent, depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        parent = new int[n + 1];
        depth = new int[n + 1];
        buildWithBFS(1); 

        int m = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.append(lca(a, b)).append('\n');
        }
        System.out.print(out);
    }

    static void buildWithBFS(int root) {
        Arrays.fill(parent, 0);
        Arrays.fill(depth, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        depth[root] = 0;
        parent[root] = 0;
        q.add(root);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (depth[v] != -1) continue;
                depth[v] = depth[u] + 1;
                parent[v] = u;
                q.add(v);
            }
        }
    }

    static int lca(int a, int b) {
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
