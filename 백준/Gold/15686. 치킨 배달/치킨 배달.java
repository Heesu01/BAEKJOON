import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) houses.add(new int[]{i, j});
                else if (city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        comb(0, 0, new int[M]);

        System.out.println(min);
    }

    static void comb(int start, int depth, int[] selected) {
        if (depth == M) {
            int distSum = 0;
            for (int[] house : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int idx : selected) {
                    int[] chick = chickens.get(idx);
                    int dist = Math.abs(house[0] - chick[0]) + Math.abs(house[1] - chick[1]);
                    minDist = Math.min(minDist, dist);
                }
                distSum += minDist;
            }
            min = Math.min(min, distSum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            comb(i + 1, depth + 1, selected);
        }
    }
}
