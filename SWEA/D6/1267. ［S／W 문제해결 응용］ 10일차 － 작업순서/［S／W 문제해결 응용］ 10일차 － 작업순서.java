import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) { // SWEA는 보통 10개 테스트
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer>[] g = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();

            int[] indegree = new int[V + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                g[A].add(B);
                indegree[B]++;
            }

            // 진입차수 0인 작업을 우선순위 큐에 넣기
            PriorityQueue<Integer> pq = new PriorityQueue<>(); //자동 오름차순
            for (int i = 1; i <= V; i++) {
                if (indegree[i] == 0) pq.add(i);
            }

            sb.append("#").append(t).append(" ");

            // 위상정렬 시작
            while (!pq.isEmpty()) {
                int cur = pq.poll();
                sb.append(cur).append(" ");

                for (int next : g[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) pq.add(next);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
