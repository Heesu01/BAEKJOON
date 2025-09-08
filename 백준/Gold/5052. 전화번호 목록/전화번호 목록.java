import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] a = new String[N];
            for (int i = 0; i < N; i++) a[i] = br.readLine().trim();

            Arrays.sort(a);
            boolean ok = true;
            for (int i = 0; i + 1 < N; i++) {
                if (a[i + 1].startsWith(a[i])) {
                    ok = false; break;
                }
            }
            out.append(ok ? "YES\n" : "NO\n");
        }
        System.out.print(out);
    }
}
