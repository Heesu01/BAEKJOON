import java.io.*;
import java.util.*;

public class Main{
    static int N, M, arr[];
    static int[] nums;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);     

        arr = new int[M];
        comb(0, 0);                      
        System.out.print(sb);
    }

    static void comb(int depth, int start){
        if (depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(i + 1 == M ? '\n' : ' ');
            }
            return;
        }
        for (int idx = start; idx < N; idx++){
            arr[depth] = nums[idx];
            comb(depth + 1, idx + 1);
        }
    }
}
