import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        bfs(N, K);
    }

    static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        int[] dist = new int[MAX + 1];
        int[] cnt  = new int[MAX + 1];
        Arrays.fill(dist, -1);

        q.offer(n);
        dist[n] = 0;
        cnt[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else next = now * 2;

                if (next < 0 || next > MAX) continue;

                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    cnt[next] = cnt[now];
                    q.offer(next);
                }
                else if (dist[next] == dist[now] + 1) {
                    cnt[next] += cnt[now];
                }
            }
        }

        System.out.println(dist[k]);
        System.out.println(cnt[k]);
    }
}
