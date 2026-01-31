import java.io.*;
import java.util.*;

public class Main {
    static int N, del, root;
    static List<Integer>[] children;
    static boolean[] removed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        children = new ArrayList[N];
        for (int i = 0; i < N; i++) children[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        root = -1;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                root = i;
            } else {
                children[p].add(i);
            }
        }

        del = Integer.parseInt(br.readLine().trim());
        removed = new boolean[N];
        removed[del] = true;

        if (del == root) {
            System.out.println(0);
            return;
        }

        int ans = dfs(root);
        System.out.println(ans);
    }

    static int dfs(int node) {
        if (removed[node]) return 0;

        int leafCount = 0;
        int validChild = 0;

        for (int nxt : children[node]) {
            if (removed[nxt]) continue;
            validChild++;
            leafCount += dfs(nxt);
        }

        if (validChild == 0) return 1;

        return leafCount;
    }
}
