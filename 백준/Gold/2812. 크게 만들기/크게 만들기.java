import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        String num = br.readLine().trim();

        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && K > 0) {
                stack.pop();
                K--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stack.size() - K; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);
    }
}