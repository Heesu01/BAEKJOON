import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int curSpeed = 0;
            int curDist = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int diff = 0;
                if (a != 0)
                    diff = Integer.parseInt(st.nextToken());
 
                if (a == 2)
                    diff = -diff;
 
                curSpeed = Math.max(0, curSpeed + diff);
                curDist += curSpeed;
            }
 
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(curDist);
            System.out.println(sb);
        }
    }
}