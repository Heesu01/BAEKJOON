import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] child = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) child[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) child[p].add(i); 
        }

        long[] add = new long[N + 1];
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            add[i] += w;
        }

        long[] ans = new long[N + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        ans[1] = add[1];

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : child[u]) {
                ans[v] = ans[u] + add[v];
                stack.push(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.print(sb.toString());
    }
}
