import java.util.*;
import java.io.*;

public class Main {
	static int N;
	
	static int Sum(int x) {
		int sum =0;
		while(x>0) {
			sum+= x % 10;
			x /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans=0;
		for (int i=1;i<=N;i++) {
			if(i+Sum(i)==N) {
				ans=i;
				break;
			}
		}
		System.out.println(ans);
		
	}
}
