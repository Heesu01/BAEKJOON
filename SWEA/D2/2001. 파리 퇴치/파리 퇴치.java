import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
   public static void main(String args[]) throws Exception
   {
      Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] board = new int[n][n];
            int sum = 0, maxSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // 합 계산 후 maxSum 값 갱신
            for (int i = 0; i < n - m + 1; i++) {
                for (int j = 0; j < n - m + 1; j++) {
                    sum = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            sum += board[i + k][j + l];
                        }
                    }
                    if (maxSum < sum) {
                        maxSum = sum;
                    }
                }
            }
            System.out.println("#" + test_case + " " + maxSum);
      }
   }
}