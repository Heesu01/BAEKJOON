import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer> tower = new ArrayList<>();

        if (a + b > n + 1) {
            System.out.print(-1);
            return;
        }

        for (int i = 1; i < a; i++) {
            tower.add(i);
        }

        tower.add(Math.max(a, b));

        for (int i = b - 1; i >= 1; i--) {
            tower.add(i);
        }

        if (a == 1) {
            while (tower.size() < n) {
                tower.add(1, 1);
            }
        } else {
            while (tower.size() < n) {
                tower.add(0, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : tower) sb.append(x).append(" ");
        System.out.print(sb);
    }
}