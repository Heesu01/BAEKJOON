import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[i][0] = d; arr[i][1] = r;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        
        for (int[] job : arr) {
            int deadline = job[0];
            int reward   = job[1];

            minHeap.offer(reward);
            if (minHeap.size() > deadline)
                minHeap.poll();
        }

        long ans = 0;
        
        while (!minHeap.isEmpty()){
            ans += minHeap.poll();
        }
        
        System.out.println(ans);
    }
}
