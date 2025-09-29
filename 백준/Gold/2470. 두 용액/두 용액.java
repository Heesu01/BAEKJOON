import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] liq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liq);
		
		int check = Integer.MAX_VALUE;
		
		int answer1 = 0; 
		int answer2 = 0; 
		
			int low = 0;
			int high = N-1;
			
			while(low<high) {
				int sum = liq[low]+liq[high];
				
				if(Math.abs(sum)<check) { 
					check = Math.abs(sum);
					answer1 = liq[low];
					answer2 = liq[high];
				}
				
				if(sum < 0) {
					low++; 
				}
				else {
					high--;
				}				
			}
		
		System.out.println(answer1+" "+answer2);
	}
}