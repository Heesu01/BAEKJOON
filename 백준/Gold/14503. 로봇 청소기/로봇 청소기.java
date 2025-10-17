import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int r, c, d;       
    static int[][] map;    
    static boolean[][] cleaned;
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = simulate();
        System.out.println(answer);
    }

    static int simulate() {
        int count = 0;

        while (true) {
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                count++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !cleaned[nx][ny]) {
                        r = nx;
                        c = ny;
                        moved = true;
                        break;
                    }
                }
            }

            if (moved) {
                continue;
            }

            int backDir = (d + 2) % 4;
            int brx = r + dx[backDir];
            int bry = c + dy[backDir];

            if (brx < 0 || bry < 0 || brx >= N || bry >= M) break;
            if (map[brx][bry] == 1) break;

            r = brx;
            c = bry;
        }

        return count;
    }
}
