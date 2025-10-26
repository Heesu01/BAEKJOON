import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight; // 비용 오름차순 정렬
    }
}

public class Main {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(start, end, weight));
        }

        // 유니온 파인드 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 간선 오름차순 정렬
        Collections.sort(edgeList);

        int total = 0;
        int maxCost = 0;

        // 크루스칼 알고리즘
        for (Edge edge : edgeList) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                total += edge.weight;
                maxCost = edge.weight;
            }
        }

        sb.append(total - maxCost).append('\n'); 
        System.out.print(sb); // 한 번에 출력
    }

    // 부모 찾기
    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    // 두 노드 합치기
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
