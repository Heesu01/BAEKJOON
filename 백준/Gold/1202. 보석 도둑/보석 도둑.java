import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(jewels, (a, b) -> a[0] - b[0]);
        Arrays.sort(bags); 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0L;
        int j = 0; 

        for (int cap : bags) {
            while (j < N && jewels[j][0] <= cap) {
                maxHeap.offer(jewels[j][1]);
                j++;
            }
            if (!maxHeap.isEmpty()) {
                total += maxHeap.poll();
            }
        }

        System.out.println(total);
    }
}
