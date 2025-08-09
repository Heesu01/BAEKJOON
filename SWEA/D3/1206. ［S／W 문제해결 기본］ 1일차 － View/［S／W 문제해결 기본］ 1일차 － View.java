import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            int result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j < N - 2; j++) {
                int max = 0;
                max = Math.max(arr[j - 2], arr[j - 1]);
                max = Math.max(max, arr[j + 1]);
                max = Math.max(max, arr[j + 2]);

                if (max < arr[j]) {
                    result += arr[j] - max;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
