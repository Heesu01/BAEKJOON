import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] video;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        
        video = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				video[i][j] = line.charAt(j) - '0';
			}
		}
		
		divide(0,0,N);
	}
	
	static void divide(int x, int y, int size) {
		if(checkSame(x,y,size)) {
			System.out.print(video[x][y]);
			return;
		}
		
		int newSize = size/2;
		System.out.print("(");
		
		divide(x,y,newSize);
		divide(x,y+newSize,newSize);
		divide(x+newSize,y,newSize);
		divide(x+newSize,y+newSize,newSize);
		
		System.out.print(")");
	}
	
	static boolean checkSame(int x, int y, int size) {
		int color = video[x][y];
		for (int i=x; i<x+size; i++) {
			for (int j=y; j<y+size; j++) {
				if(color != video[i][j]) return false;
			}
		}
		return true;
	}
}
