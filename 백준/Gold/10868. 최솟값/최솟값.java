import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static long[] arr;
    public static long[] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        int size = (int) Math.pow(2, k);

        tree = new long[size];

        init(1, n, 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(find(1, n, left, right, 1)).append('\n');
        }

        System.out.print(sb.toString());

        br.close();
    }

    public static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = Math.min(
                init(start, mid, node * 2),
                init(mid + 1, end, node * 2 + 1)
        );
    }

    public static long find(int start, int end, int left, int right, int node) {
        if (right < start || end < left) {
            return 1_000_000_001L; 
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(
                find(start, mid, left, right, node * 2),
                find(mid + 1, end, left, right, node * 2 + 1)
        );
    }
}
