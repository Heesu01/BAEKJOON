import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			
			PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> big = new PriorityQueue<>();
			
			int N= Integer.parseInt(br.readLine());
			System.out.println(N/2+1);
			
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				int num = Integer.parseInt(st.nextToken());
                if (j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
				
				if(small.size()==big.size()) {
					small.add(num);
				} else {
					big.add(num);
				}
				
				if(!big.isEmpty()&&small.peek()>big.peek()) {
					int a = small.poll();
					int b = big.poll();
					
					small.add(b);
					big.add(a);
				}
				
				if(j%2!=0) {
					System.out.print(small.peek()+" ");
				}
			}
			System.out.println();
		}
				
		
	}

}
