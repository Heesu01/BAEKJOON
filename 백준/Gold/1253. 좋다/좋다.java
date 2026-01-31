import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int good = 0;

        for (int i = 0; i < N; i++) {
            long target = A[i];
            int l = 0, r = N - 1;

            while (l < r) {
                if (l == i) { l++; continue; }
                if (r == i) { r--; continue; }

                long sum = A[l] + A[r];

                if (sum == target) {
                    good++;
                    break;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.println(good);
    }
}
