import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] nums, pick;
    static boolean[] visit; 
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

        pick = new int[M];
        visit = new boolean[N];

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth){
        if (depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(pick[i]).append(i + 1 == M ? '\n' : ' ');
            }
            return;
        }
        for (int i = 0; i < N; i++){
            if (visit[i]) continue;
            visit[i] = true;
            pick[depth] = nums[i]; 
            dfs(depth + 1);
            visit[i] = false;
        }
    }
}
