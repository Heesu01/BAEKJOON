import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] dir = new int[12];
        int[] len = new int[12];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = dir[i+6] = Integer.parseInt(st.nextToken());
            len[i] = len[i+6] = Integer.parseInt(st.nextToken());
        }

        int maxArea = 0;
        int subArea = 0;

        for (int i = 0; i < 6; i++) {
            int cur = len[i] * len[i+1];
            if (cur > maxArea) {
                maxArea = cur;
                subArea = len[i+3] * len[i+4]; 
            }
        }

        System.out.println((maxArea - subArea) * K);
    }
}
