
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] v = new boolean[100][100];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int j=a;j<a+10;j++) {
				for(int k=b;k<b+10;k++) {
					v[j][k]=true;
				}
			}
		}
		int ans =0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(v[i][j]) {
					ans+=1;
				}
			}
		}
		System.out.println(ans);
	}
}
