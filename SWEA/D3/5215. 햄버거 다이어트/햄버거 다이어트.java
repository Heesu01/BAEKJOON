import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int N, L, maxScore;
    static int[] score, calorie;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  
            L = Integer.parseInt(st.nextToken());  
 
            score = new int[N];
            calorie = new int[N];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
 
            maxScore = 0;
            dfs(0, 0, 0);  
 
            sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
        }
 
        System.out.print(sb.toString());
        br.close();
    }
 
    static void dfs(int idx, int scoreSum, int calSum) {
        if (calSum > L) return;  
        if (idx == N) { 
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }
 
        dfs(idx + 1, scoreSum + score[idx], calSum + calorie[idx]);
        dfs(idx + 1, scoreSum, calSum);
    }
}