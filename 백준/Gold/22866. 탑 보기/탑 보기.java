import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] h = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) h[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[N + 1];
        int[] near = new int[N + 1];
        Stack<Integer> stack;

        stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop();
            cnt[i] = stack.size();
            if (cnt[i] > 0) near[i] = stack.peek();  
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop();
            int s = stack.size();
            cnt[i] += s;
            if (s > 0) {
                int cand = stack.peek();
                if (near[i] == 0 || (cand - i) < (i - near[i])) near[i] = cand;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) sb.append(0).append('\n');
            else sb.append(cnt[i]).append(' ').append(near[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}