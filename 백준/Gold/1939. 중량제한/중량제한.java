import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<int[]>[] graph; 
    static int start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        int maxWeight = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});

            if (w > maxWeight) maxWeight = w;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = maxWeight;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canGo(mid)) {  
                answer = mid;
                left = mid + 1;
            } else {        
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canGo(int weight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == end) return true;

            for (int[] next : graph[now]) {
                int to = next[0];
                int w = next[1];

                if (!visited[to] && w >= weight) {
                    visited[to] = true;
                    q.offer(to);
                }
            }
        }

        return false;
    }
}
