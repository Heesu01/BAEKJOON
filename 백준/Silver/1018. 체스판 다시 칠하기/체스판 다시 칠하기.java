import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        int answer = 64; 

        for (int si = 0; si <= N - 8; si++) {
            for (int sj = 0; sj <= M - 8; sj++) {
                int repaintW = 0; 
                int repaintB = 0; 

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        char cur = board[si + i].charAt(sj + j);

                        char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                        char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                        if (cur != expectedW) repaintW++;
                        if (cur != expectedB) repaintB++;
                    }
                }

                int repaint = Math.min(repaintW, repaintB);
                answer = Math.min(answer, repaint);
            }
        }

        System.out.println(answer);
    }
}
