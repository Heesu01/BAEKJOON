import java.util.*;
import java.io.*;

public class Main {	
    static int n, m;
    static int[][] map;
    static boolean[][] v;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		v = new boolean[n][m];
		int count =0, maxArea=0;
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if(map[i][j]==1 && !v[i][j]) {
					count++;
					maxArea = Math.max(maxArea, bfs(i,j));
				}
			}
		}
		System.out.println(count);
		System.out.println(maxArea);

	}
	static int bfs(int sr,int sc) {
		ArrayDeque<int[]> q= new ArrayDeque<>();
		q.add(new int[] {sr,sc});
		v[sr][sc] =  true;
		
		int area =0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r= cur[0], c= cur[1];
			area++;
			
			for(int d=0;d<4;d++) {
				int nr = r + dr[d], nc= c +dc[d];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				 if (v[nr][nc] || map[nr][nc] == 0) continue;
				 v[nr][nc] = true;
				  q.add(new int[]{nr, nc});
			}
		}
		return area;
	}
}
