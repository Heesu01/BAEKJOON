import java.io.*;
import java.util.*;

public class Main {
    static int[] getPi(String p) {
        int[] pi = new int[p.length()];
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = pi[j - 1];
            if (p.charAt(i) == p.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }

    static int kmpCount(String t, String p) {
        int[] pi = getPi(p);
        int j = 0, cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) j = pi[j - 1];
            if (t.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    cnt++;
                    j = pi[j];
                } else j++;
            }
        }
        return cnt;
    }

    static int gcd(int a, int b) {
        while (b != 0) { int r = a % b; a = b; b = r; }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < N; i++) {
            a.append(st.nextToken()).append('#'); 
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < N; i++) {
            b.append(st.nextToken()).append('#');
        }

        String A = a.toString();
        String B = b.toString();

        String T = A + A.substring(0, A.length() - 1);

        int matches = kmpCount(T, B);
        int g = gcd(matches, N);
        System.out.println((matches / g) + "/" + (N / g));
    }
}
