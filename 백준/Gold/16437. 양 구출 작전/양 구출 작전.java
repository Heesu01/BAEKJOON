import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] vertex;
    static List<Integer>[] edgeList;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vertex = new long[N + 1];
        edgeList = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String kind = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (kind.equals("S")) {
                vertex[i] = cnt;
            } else {
                vertex[i] = -cnt;
            }
            edgeList[to].add(i);
        }

        long result = dfs(1);
        sb.append(result).append('\n');

        System.out.print(sb);
    }

    public static long dfs(int v) {
        visit[v] = true;
        long sum = vertex[v];

        for (int nv : edgeList[v]) {
            if (!visit[nv]) {
                sum += dfs(nv);
            }
        }

        if (sum < 0) {
            sum = 0;
        }

        return sum;
    }
}
