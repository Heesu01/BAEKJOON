import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Set<Integer>> likeMap = new HashMap<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        List<Integer> studentOrder = new ArrayList<>();

        // 입력 처리
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            studentOrder.add(student);

            Set<Integer> likes = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                likes.add(Integer.parseInt(st.nextToken()));
            }
            likeMap.put(student, likes);
        }

        for (int student : studentOrder) {
            placeStudent(student);
        }

        System.out.println(calculateSatisfaction());
    }

    private static void placeStudent(int student) {
        List<int[]> candidates = new ArrayList<>();
        int maxLike = -1;
        int maxEmpty = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) continue;

                int likeCount = 0;
                int emptyCount = 0;

                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;

                    if (board[ni][nj] == 0) emptyCount++;
                    else if (likeMap.get(student).contains(board[ni][nj])) likeCount++;
                }

                candidates.add(new int[]{likeCount, emptyCount, i, j});
            }
        }

        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1];
            if (a[2] != b[2]) return a[2] - b[2];
            return a[3] - b[3];
        });

        int[] chosen = candidates.get(0);
        board[chosen[2]][chosen[3]] = student;
    }

    private static int calculateSatisfaction() {
        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = board[i][j];
                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;

                    if (likeMap.get(student).contains(board[ni][nj])) count++;
                }

                if (count > 0) {
                    total += Math.pow(10, count - 1);
                }
            }
        }

        return total;
    }
}
