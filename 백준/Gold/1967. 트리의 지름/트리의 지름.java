import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<int[]>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[p].add(new int[]{c, w});
            tree[c].add(new int[]{p, w});
        }

        int[] a = farthestBFS(1);    
        int[] b = farthestBFS(a[0]);  
        System.out.println(b[1]);
    }

    static int[] farthestBFS(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        int farNode = start, farDist = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int curDist = dist[cur];

            if (curDist > farDist) {
                farDist = curDist;
                farNode = cur;
            }

            for (int[] e : tree[cur]) {
                int to = e[0], w = e[1];
                if (dist[to] != -1) continue;
                dist[to] = curDist + w;
                q.add(to);
            }
        }
        return new int[]{farNode, farDist};
    }
}
