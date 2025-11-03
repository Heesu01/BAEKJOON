import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int maxH = 0, ans=0, cnt;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]>maxH) maxH= map[i][j];
			}
		}
		
		for(int h=0;h<maxH;h++) {
			int cnt=0;
			v = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>h && !v[i][j]) {
						cnt++;
						bfs(i,j,h);
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}	
		
		System.out.println(ans);
	}
	
	
	static void bfs(int x,int y,int h) {
		Queue<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int d=0;d<4;d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(nx>=N || ny>=N || ny<0 || nx<0) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny]<=h) continue;
				
				v[nx][ny]= true;
				q.add(new int[] {nx,ny});
			}
		}
		
	}
}