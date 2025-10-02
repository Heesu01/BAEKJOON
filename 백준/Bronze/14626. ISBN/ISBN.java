import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int starIdx = -1;
        int sum = 0;

        for (int i = 0; i < 13; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                starIdx = i;
                continue;
            }

            int d = c - '0';
            int w;
            if (i % 2 == 0) { 
                w = 1;
            } else {   
                w = 3;
            }
            sum += d * w;
        }

        int wStar;
        if (starIdx % 2 == 0) wStar = 1;
        else wStar = 3;

        for (int x = 0; x <= 9; x++) {
            int total = sum + wStar * x;
            if (total % 10 == 0) {
                System.out.println(x);
                return;
            }
        }
    }
}
