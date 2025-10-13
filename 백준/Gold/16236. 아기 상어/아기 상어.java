import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {-1, 0, 0, 1}; 
    static final int[] dy = {0, -1, 1, 0};

    static int N;
    static int[][] map;

    static int sx, sy;
    static int size = 2;   
    static int eaten = 0; 
    static int time = 0;    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i; sy = j;
                    map[i][j] = 0; 
                }
            }
        }

        while (true) {
            Target t = bfsFindTarget();
            if (t == null) break; 
       
            time += t.dist;
            sx = t.x; sy = t.y;
            map[sx][sy] = 0; 
            eaten++;
            if (eaten == size) {  
                size++;
                eaten = 0;
            }
        }

        System.out.println(time);
    }

    static Target bfsFindTarget() {
        boolean[][] visited = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        int bestX = -1, bestY = -1, bestDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if (d > bestDist) break;

            if (map[x][y] > 0 && map[x][y] < size) {
                if (d < bestDist ||
                   (d == bestDist && (x < bestX || (x == bestX && y < bestY)))) {
                    bestDist = d;
                    bestX = x;
                    bestY = y;
                }
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > size) continue; 

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, d + 1});
            }
        }

        if (bestX == -1) return null;
        return new Target(bestX, bestY, bestDist);
    }

    static class Target {
        int x, y, dist;
        Target(int x, int y, int dist) {
            this.x = x; this.y = y; this.dist = dist;
        }
    }
}
