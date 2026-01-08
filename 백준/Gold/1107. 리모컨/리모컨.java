import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean possible = true;

            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';
                if (broken[digit]) {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            int cnt = s.length() + Math.abs(i-N);

            ans = Math.min(ans, cnt);
        }

        System.out.println(ans);
    }
}
