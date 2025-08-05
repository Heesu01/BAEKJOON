import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int d = 0; d < dump; d++) {
                int minIdx = 0, maxIdx = 0;
                for (int i = 1; i < 100; i++) {
                    if (arr[i] < arr[minIdx]) minIdx = i;
                    if (arr[i] > arr[maxIdx]) maxIdx = i;
                }
                arr[minIdx]++;
                arr[maxIdx]--;

                int diff = arr[maxIdx] - arr[minIdx];
                if (diff <= 1) break;
            }

            int min = arr[0];
			int max = arr[0];
            for (int h : arr) {
                min = Math.min(min, h);
                max = Math.max(max, h);
            }

            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }

        System.out.print(sb);
    }
}
