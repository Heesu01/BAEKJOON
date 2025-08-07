
import java.io.*;
import java.util.*;

public class Solution {
    static int N, L, r, maxScore;
    static int[] taste, cal;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            L = Integer.parseInt(st.nextToken()); 

            taste = new int[N];
            cal = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0;

            // 조합 길이를 1부터 N까지 순차적으로 설정하며 조합 생성
            for (r = 1; r <= N; r++) {
                selected = new int[r];
                comb(0, 0); // 
            }

            sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
        }

        System.out.print(sb);
    }

    // 조합 생성: cnt는 뽑은 수, start는 시작 인덱스
    static void comb(int cnt, int start) {
        if (cnt == r) {
            int sumTaste = 0;
            int sumCal = 0;
            for (int i = 0; i < r; i++) {
                sumTaste += taste[selected[i]];
                sumCal += cal[selected[i]];
            }
            if (sumCal <= L) {
                maxScore = Math.max(maxScore, sumTaste);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
}
