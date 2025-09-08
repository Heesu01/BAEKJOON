import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map = new int[9][9];
	static List<int[]> empty = new ArrayList<>();
	
	public static void sudoku(int cnt) {
		if(cnt == empty.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int x = empty.get(cnt)[0];
		int y = empty.get(cnt)[1];
		int startX = x / 3 * 3;
		int startY = y / 3 * 3;
		boolean[] check = new boolean[9];
		
		for(int i = 0; i < 9; i++) {
			if(map[x][i] > 0) check[map[x][i]-1] = true;
			if(map[i][y] > 0) check[map[i][y]-1] = true;
		}
		for(int i = startX; i < startX+3; i++) {
			for(int j = startY; j < startY+3; j++) {
				if(map[i][j] > 0) check[map[i][j]-1] = true;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(!check[i]) {
				map[x][y] = i+1;
				sudoku(cnt+1);
				map[x][y] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i ++) {
			String str = in.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 0) empty.add(new int[]{i, j});
			}
		}
		
		sudoku(0);
	}
}
