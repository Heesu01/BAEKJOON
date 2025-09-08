import java.io.*;
import java.util.*;

public class Main {
    static int K;  
    static char[] sign; 
    static boolean[] used = new boolean[10];
    static String minAns = null, maxAns = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sign = new char[K];
        for (int i = 0; i < K; i++) sign[i] = st.nextToken().charAt(0);

        dfs(0, new StringBuilder());

        System.out.println(maxAns);
        System.out.println(minAns);
    }

    static void dfs(int depth, StringBuilder sb) {
        if (depth == K + 1) {
            String cur = sb.toString();
            if (minAns == null || cur.compareTo(minAns) < 0) minAns = cur;
            if (maxAns == null || cur.compareTo(maxAns) > 0) maxAns = cur;
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (used[d]) continue;

            if (depth > 0) {
                int prev = sb.charAt(depth - 1) - '0';
                char rel = sign[depth - 1];

                if (rel == '<' && !(prev < d)) continue;
                if (rel == '>' && !(prev > d)) continue;
            }

            used[d] = true;
            sb.append(d);
            dfs(depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            used[d] = false;
        }
    }
}
