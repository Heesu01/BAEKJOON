import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        
        int[][] time = new int[n+1][2];
 
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0]=Integer.parseInt(st.nextToken());
            time[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time, (a,b) ->{
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
 
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(time[1][1]);
        
        for(int i=2; i<=n; i++){
		    int start = time[i][0];
            int end = time[i][1];
            
            if(pq.peek() <= start){
                pq.poll();
            }
            pq.add(end);
        }
        System.out.println(pq.size() );
    }
}