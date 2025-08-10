import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] li = new int[9];
		int sum = 0;
		for (int i=0;i<9;i++) {
			li[i]=Integer.parseInt(br.readLine());
			sum+=li[i];
		}
		
		int a=-1, b=-1;
		int target = sum -100;
		
		
		for (int i=0;i<9;i++) {
			for (int j=i+1;j<9;j++) {
				if(li[i]+li[j]==target) {
					a=i;
					b=j;
					i = 9; 
					break;
				}
			}
		}
		
		int[] ans = new int[7];
		int idx=0;
		for(int i=0;i<9;i++) {
			if(i==a || i==b) continue;
			ans[idx++]=li[i];
		}
		Arrays.sort(ans);
		
		for(int i:ans) {
			System.out.println(i);
		}
		
	}
}
