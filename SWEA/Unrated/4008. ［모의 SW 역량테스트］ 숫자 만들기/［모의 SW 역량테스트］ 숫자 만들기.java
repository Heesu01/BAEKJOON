import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] nums;
    static int[] ops;
    static int maxVal, minVal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            StringTokenizer st = new StringTokenizer(br.readLine());
            ops = new int[4];
            for (int i = 0; i < 4; i++) ops[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

            maxVal = Integer.MIN_VALUE;
            minVal = Integer.MAX_VALUE;

            dfs(1, nums[0]);

            out.append('#').append(tc).append(' ').append(maxVal - minVal).append('\n');
        }

        System.out.print(out.toString());
    }

    static void dfs(int idx, int cur) {
        if (idx == N) {
            maxVal = Math.max(maxVal, cur);
            minVal = Math.min(minVal, cur);
            return;
        }

        for (int op = 0; op < 4; op++) {
            if (ops[op] == 0) continue;
            ops[op]--;
            int next = apply(cur, nums[idx], op);
            dfs(idx + 1, next);
            ops[op]++;
        }
    }

    static int apply(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            default: return a / b;  
        }
    }
}
