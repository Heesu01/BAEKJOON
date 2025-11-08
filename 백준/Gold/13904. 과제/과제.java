import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] task = new int[N][2]; 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            task[i][0] = d;
            task[i][1] = w;
        }

        Arrays.sort(task, (a, b) -> a[0] - b[0]); 

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        for (int[] t : task) {
		        
            minHeap.offer(t[1]);         
            if (minHeap.size() > t[0]) {  
                minHeap.poll();
            }
        }

        long sum = 0;
        while (!minHeap.isEmpty()) sum += minHeap.poll();
        System.out.println(sum);
    }
}
