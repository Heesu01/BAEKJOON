import java.io.*;
import java.util.*;

public class Main {
	static int N,M,sx,sy;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				dist[i][j]=-1;
				if(map[i][j]==2) {
					dist[i][j]=0;
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs();
		
		 for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	            	if(map[i][j]==0) {
	            		System.out.print(0);
	            	} else {
	            		System.out.print(dist[i][j]);
	            	}
	            	 if (j < M - 1) System.out.print(" ");
	            }
	            System.out.println();
		 }
		
	}
	
	static void bfs() {
		Queue<int[]> pq = new ArrayDeque<>();
		pq.add(new int[] {sx,sy});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			
			
			for(int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx>=N || ny>=M || nx<0 || ny<0|| map[nx][ny]==0) continue;
				
				if(dist[nx][ny]==-1) {
					dist[nx][ny] = dist[x][y]+1;
					pq.add(new int[] {nx,ny});
				}
			}
		}
	}
}