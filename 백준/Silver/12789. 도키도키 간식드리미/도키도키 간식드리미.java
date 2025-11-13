import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int need = 1;
        int idx = 0;

        while (idx < N) {
            int cur = arr[idx];

            if (!stack.isEmpty() && stack.peek() == need) {
                stack.pop();
                need++;
            } else if (cur == need) {
                need++;
                idx++;
            } else {
                stack.push(cur);
                idx++;
            }
        }

        while (!stack.isEmpty() && stack.peek() == need) {
            stack.pop();
            need++;
        }

        if (need == N + 1) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
