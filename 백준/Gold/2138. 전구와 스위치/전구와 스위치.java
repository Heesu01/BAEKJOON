import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] now, want, nowA, nowB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        now = new boolean[N];
        want = new boolean[N];

        switchState(br.readLine().trim(), now);
        switchState(br.readLine().trim(), want);

        nowA = Arrays.copyOf(now, N);
        nowB = Arrays.copyOf(now, N);

        int switchA = 0, switchB = 0;

        switchOn(0, nowA);
        switchA++;

        for (int i = 1; i < N; i++) {
            if (nowA[i - 1] != want[i - 1]) {
                switchOn(i, nowA);
                switchA++;
            }
            if (nowB[i - 1] != want[i - 1]) {
                switchOn(i, nowB);
                switchB++;
            }
        }
        
        int ans = Integer.MAX_VALUE;
				if (Arrays.equals(nowA, want)) ans = switchA;
				if (Arrays.equals(nowB, want)) ans = Math.min(ans, switchB);
						
				if (ans == Integer.MAX_VALUE) System.out.println(-1);
				else System.out.println(ans);
    }

    static void switchOn(int i, boolean[] arr) {
        if (i - 1 >= 0) arr[i - 1] = !arr[i - 1];
        arr[i] = !arr[i];
        if (i + 1 < N) arr[i + 1] = !arr[i + 1];
    }

    static void switchState(String s, boolean[] arr) {
				for (int i = 0; i < s.length(); i++) {
				    char c = s.charAt(i);
				    if (c == '1') {
				        arr[i] = true;
				    } else {
				        arr[i] = false; 
				    }
				}
    }
}
