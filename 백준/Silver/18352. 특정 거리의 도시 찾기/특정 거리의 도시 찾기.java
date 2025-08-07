import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[X] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : graph.get(current)) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    q.add(next);
                }
            }
        }

        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                found = true;
            }
        }

        System.out.print(found ? sb.toString() : "-1");
    }
}
