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
        arr = new int[M];

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        dupPerm(0);
        System.out.println(sb);
    }

    public static void dupPerm(int depth){
        if (depth == M){
            for (int x : arr) sb.append(x).append(" ");
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++){
            arr[depth] = nums[i];
            dupPerm(depth + 1);
        }
    }
}
