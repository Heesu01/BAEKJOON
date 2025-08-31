import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int blue=0;
	static int white =0;
	static int[][] paper;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	
	static void divide(int x, int y, int size) {
		if(checkColor(x,y,size)) {
			if(paper[x][y]==0) white++;
			else blue++;
			return;
		}
		
		int newSize = size/2;
		divide(x,y,newSize);
		divide(x,y+newSize,newSize);
		divide(x+newSize,y,newSize);
		divide(x+newSize,y+newSize,newSize);
	}
	
	
	static boolean checkColor(int x, int y, int size) {
		int color = paper[x][y];
		for (int i=x;i<x+size;i++) {
			for (int j=y; j<y+size;j++) {
				if(paper[i][j]!=color) return false;
			}
		}
		return true;
	}
}
