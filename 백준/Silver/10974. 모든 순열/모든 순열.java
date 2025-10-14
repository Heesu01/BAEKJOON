import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] result;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        result = new int[N];
        used = new boolean[N + 1];

        perm(0);
        System.out.print(sb.toString());
    }

    static void perm(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(result[i]);
                if (i + 1 < N) sb.append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                result[depth] = i;
                perm(depth + 1);
                used[i] = false;
            }
        }
    }
}
