import java.io.*;
import java.util.*;

public class Main {
    static int[] li;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        li = new int[N];
        for (int i = 0; i < N; i++) li[i] = i + 1;

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            reverse(i, j);
        }

        for (int i : li) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static void reverse(int i, int j) {
        int l = i - 1; 
        int r = j - 1;
        while (l < r) {
            int temp = li[l];
            li[l] = li[r];
            li[r] = temp;
            l++;
            r--;
        }
    }
}
