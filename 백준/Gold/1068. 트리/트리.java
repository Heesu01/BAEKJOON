import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int N, removeNode, ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) { 
                root = i;
            } else {
                tree[p].add(i); 
            }
        }

        removeNode = Integer.parseInt(br.readLine());

        if (removeNode == root) { 
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(ans);
        }
    }

    static void dfs(int cur) {
        if (cur == removeNode) return;

        int childCount = 0;
        for (int nxt : tree[cur]) {
            if (nxt == removeNode) continue;
            dfs(nxt);
            childCount++;
        }

        if (childCount == 0) { 
            ans++;
        }
    }
}
