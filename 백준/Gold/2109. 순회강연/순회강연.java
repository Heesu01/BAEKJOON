import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] lec = new int[n][2]; 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); 
            int d = Integer.parseInt(st.nextToken()); 
            lec[i][0] = d;
            lec[i][1] = p;
        }

        Arrays.sort(lec, (a, b) -> a[0] - b[0]); 

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] x : lec) {
            int d = x[0], p = x[1];
            minHeap.offer(p);
            if (minHeap.size() > d) minHeap.poll();
        }

        long sum = 0;
        while (!minHeap.isEmpty()) sum += minHeap.poll();
        System.out.println(sum);
    }
}
