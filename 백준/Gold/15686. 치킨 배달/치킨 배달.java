import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> shops = new ArrayList<>();
    static int[] pick;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) homes.add(new int[]{r, c});
                else if (v == 2) shops.add(new int[]{r, c});
            }
        }

        pick = new int[M];
        comb(0, 0); 

        System.out.println(answer);
    }

    static void comb(int depth, int start) {
        if (depth == M) {
            answer = Math.min(answer, cityChickenDistance());
            return;
        }
        for (int i = start; i < shops.size(); i++) {
            pick[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    static int cityChickenDistance() {
        int sum = 0;
        for (int[] h : homes) {
            int hr = h[0], hc = h[1];
            int best = Integer.MAX_VALUE;
            for (int idx : pick) {
                int[] s = shops.get(idx);
                int dist = Math.abs(hr - s[0]) + Math.abs(hc - s[1]);
                if (dist < best) best = dist;
            }
            sum += best;
            if (sum >= answer) return sum;
        }
        return sum;
    }
}
