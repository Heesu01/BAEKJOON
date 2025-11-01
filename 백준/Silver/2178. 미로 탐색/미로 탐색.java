import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
	
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for (int j=0;j<M;j++) {
				map[i][j]= line.charAt(j) - '0';
				dist[i][j]=-1;
			}
		}
		
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		dist[0][0]=1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int d=0;d<4;d++) {
				int nx = x+ dx[d];
				int ny = y+ dy[d];
				
				if(nx>=N || ny>=M || nx<0 || ny <0 || map[nx][ny]==0) continue;
				
				if(dist[nx][ny]==-1) {
					dist[nx][ny] = dist[x][y]+1;
					q.add(new int[] {nx,ny});				
				}
				
			}
		}
		System.out.println(dist[N-1][M-1]);
	}
}