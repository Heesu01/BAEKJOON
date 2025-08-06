import java.io.*;
import java.util.*;

public class Solution {
    static int[] gyu;      
    static boolean[] used;    
    static int[] iny;        
    static int winCount, loseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            gyu = new int[9];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) gyu[i] = Integer.parseInt(st.nextToken());

            used = new boolean[19]; 
            for (int x : gyu) used[x] = true;

            iny = new int[9];
            winCount = 0;
            loseCount = 0;

            permute(0);

            System.out.println("#" + tc + " " + winCount + " " + loseCount);
        }
    }

    static void permute(int idx) {
        if (idx == 9) {
            int gyuScore = 0, inyScore = 0;
            for (int i = 0; i < 9; i++) {
                int g = gyu[i], y = iny[i];
                int sum = g + y;
                if (g > y) gyuScore += sum;
                else if (y > g) inyScore += sum;
            }
            if (gyuScore > inyScore) winCount++;
            else if (gyuScore < inyScore) loseCount++;
            return;
        }

        for (int card = 1; card <= 18; card++) {
            if (!used[card]) {
                used[card] = true;
                iny[idx] = card;
                permute(idx + 1);
                used[card] = false;
            }
        }
    }
}
