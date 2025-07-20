import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String memory = br.readLine();
            int cnt = 0;
            char prev = '0'; 

            for (int i = 0; i < memory.length(); i++) {
                char cur = memory.charAt(i);
                if (cur != prev) {
                    cnt++;
                    prev = cur;
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
