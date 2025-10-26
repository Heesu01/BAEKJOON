import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int s, e, v;
        Node(int s, int e, int v) { this.s = s; this.e = e; this.v = v; }
        @Override public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }
    }

    static int N, M;
    static int[] parent;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; 
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        parent = new int[N];
        Arrays.fill(parent, -1);

        long ans = buildTwoVillages();
        System.out.println(ans);
    }

    private static long buildTwoVillages() {
        long sum = 0L;
        int picked = 0;

        while (!pq.isEmpty() && picked < N - 2) { 
            Node cur = pq.poll();
            if (union(cur.s, cur.e)) {
                sum += cur.v;
                picked++;
            }
        }
        return sum; 
    }

    
    private static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        parent[b] = a; 
        return true;
    }
}
