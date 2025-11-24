import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals(".")) break;

            int n = s.length();
            int[] pi = buildPi(s);

            int l = pi[n - 1]; 
            int p = n - l; 

            int k;
            if (n % p == 0) {
                k = n / p;
            } else {
                k = 1;
            }

            sb.append(k).append('\n');
        }

        System.out.print(sb);
    }

    private static int[] buildPi(String s) {
        int n = s.length();
        int[] pi = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }

        return pi;
    }
}
