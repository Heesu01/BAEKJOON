import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> dec = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for (int d = 0; d <= 9; d++) {
            dfs(d, d);  
        }

        Collections.sort(dec);
        System.out.println(dec.get(N));
    }

    static void dfs(int last, long cur) {
        dec.add(cur); 

        for (int next = 0; next < last; next++) {
            long nxtNum = cur * 10 + next;
            dfs(next, nxtNum);
        }
    }
}
