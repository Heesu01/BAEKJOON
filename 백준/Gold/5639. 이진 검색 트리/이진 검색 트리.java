import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { this.val = v; }
    }

    static Node root;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null && s.length() > 0) {
            int x = Integer.parseInt(s.trim());
            root = insert(root, x);
        }

        postorder(root);
        System.out.print(out);
    }

    static Node insert(Node cur, int x) {
        if (cur == null) return new Node(x);
        if (x < cur.val) cur.left = insert(cur.left, x);
        else             cur.right = insert(cur.right, x);
        return cur;
    }

    static void postorder(Node cur) {
        if (cur == null) return;
        postorder(cur.left);
        postorder(cur.right);
        out.append(cur.val).append('\n');
    }
}
