import java.io.*;
import java.util.*;

public class Main{
    static int N, M, arr[];
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        comb(0, 1); 
        System.out.println(sb);
    }

    public static void comb(int depth, int start){
        if (depth == M){
            for (int x : arr) sb.append(x).append(" ");
            sb.append('\n');
            return;
        }

        for (int num = start; num <= N; num++){ 
            arr[depth] = num;                   
            comb(depth + 1, num);
        }
    }
}
