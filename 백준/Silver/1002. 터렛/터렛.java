import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            long dx = (long)x1 - x2;
            long dy = (long)y1 - y2;
            long d2 = dx*dx + dy*dy;       
            long rp = (long)r1 + r2;        
            long rm = Math.abs((long)r1 - r2);
            long rp2 = rp * rp;
            long rm2 = rm * rm;

            int ans;


            if (d2 == 0 && r1 == r2) {
                ans = -1;
            }
   
            else if (d2 > rp2) {
                ans = 0;
            } else if (d2 < rm2) {
                ans = 0;
            }
            else if (d2 == rp2) {
                ans = 1;
            } else if (d2 == rm2) {
                ans = 1;
            }
            else {
                ans = 2;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
