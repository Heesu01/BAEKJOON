import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) System.out.println(N - K);
        else System.out.println(bfs(N, K));
    }

    static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] subin = new int[100001];

        q.offer(n);
        subin[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else next = now * 2;

                if (next == k) return subin[now];

                if (0 <= next && next <= 100000 && subin[next] == 0) {
                    q.offer(next);
                    subin[next] = subin[now] + 1;
                }
            }
        }
        return 0;
    }
}