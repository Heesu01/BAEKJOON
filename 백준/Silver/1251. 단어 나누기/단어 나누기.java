import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();

        String best = null;

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) { 
                String a = reverse(s.substring(0, i));
                String b = reverse(s.substring(i, j));
                String c = reverse(s.substring(j));

                String cand = a + b + c;

                if (best == null || cand.compareTo(best) < 0) {
                    best = cand;
                }
            }
        }

        System.out.println(best);
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
