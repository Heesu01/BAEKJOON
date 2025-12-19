import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int testCase = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println("#" + testCase + " " + pow(n, m));
        }
    }
    
        static int pow(int n, int m) {
        if (m == 0) return 1;
        return n * pow(n, m - 1);
    }
}
