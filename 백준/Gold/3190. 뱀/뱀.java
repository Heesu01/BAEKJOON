import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); 

        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N]; 

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 2;
        }

        int L = Integer.parseInt(br.readLine()); 

        int[] turnTime = new int[L];
        char[] turnDir = new char[L];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            turnTime[i] = Integer.parseInt(st.nextToken());
            turnDir[i] = st.nextToken().charAt(0); 
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;

        Deque<int[]> snake = new ArrayDeque<>();
        snake.offerFirst(new int[]{0, 0});
        board[0][0] = 1; 

        int time = 0;
        int turnIdx = 0;

        while (true) {
            time++;

            int[] head = snake.peekFirst();
            int x = head[0];
            int y = head[1];

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            if (board[nx][ny] == 1) {
                break;
            }

            if (board[nx][ny] == 2) {
                board[nx][ny] = 1;
                snake.offerFirst(new int[]{nx, ny});
            } else {
                board[nx][ny] = 1;
                snake.offerFirst(new int[]{nx, ny});

                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            if (turnIdx < L && turnTime[turnIdx] == time) {
                char c = turnDir[turnIdx];
                if (c == 'L') {
                    dir = (dir + 3) % 4; 
                } else if (c == 'D') {
                    dir = (dir + 1) % 4;
                }
                turnIdx++;
            }
        }

        System.out.println(time);
    }
}
