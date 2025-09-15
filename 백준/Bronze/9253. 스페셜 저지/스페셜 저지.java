import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        boolean ok = A.contains(C) && B.contains(C);

        if (ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
