import java.io.*;
import java.util.*;

public class Main {

    // 트라이 노드 정의
    static class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean end;
    }

    // 트라이에 단어 삽입 함수
    static void insert(Node root, String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cur.next.putIfAbsent(c, new Node());
            cur = cur.next.get(c);
        }
        cur.end = true;
    }

    // 특정 단어를 입력할 때 필요한 키 입력 수 계산
    static int keypress(Node root, String s) {
        Node cur = root;
        int count = 0;

		for (int i = 0; i < s.length(); i++) {
		    if (i == 0 || cur.end || cur.next.size() > 1) {
		        count++;
		    }
		    cur = cur.next.get(s.charAt(i));
		}
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; 

            int n = Integer.parseInt(line);

            Node root = new Node();
            List<String> words = new ArrayList<>(n); 

            // 단어들을 입력받아 트라이에 삽입
            for (int i = 0; i < n; i++) {
                String w = br.readLine().trim();
                words.add(w);
                insert(root, w);
            }

            // 각 단어마다 필요한 입력 횟수를 합산
            long sum = 0;
            for (String w : words) sum += keypress(root, w);

            double avg = (double) sum / n;

            System.out.printf("%.2f%n", avg);
        }
    }
}
