import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> note = new HashMap<>();
    static int N, M;
    static int[] stringNote;
    static int[] chordNote;
    static int[] choice;
    static int[] used;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        initNoteMap();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stringNote = new int[N];
        chordNote = new int[M];
        choice = new int[N];
        used = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stringNote[i] = note.get(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            chordNote[i] = note.get(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx == N) {
            for (int i = 0; i < M; i++) {
                if (used[i] == 0) return;
            }

            int diff = calcDifficulty();
            answer = Math.min(answer, diff);
            return;
        }

        for (int j = 0; j < M; j++) {
            used[j]++;
            choice[idx] = j;

            dfs(idx + 1);

            used[j]--;
        }
    }

    static int calcDifficulty() {
        ArrayList<Integer> frets = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int s = stringNote[i];
            int c = chordNote[choice[i]];

            int f = (c - s + 12) % 12;
            if (f != 0) frets.add(f);
        }

        if (frets.size() == 0) return 0;
        if (frets.size() == 1) return 1;

        Collections.sort(frets);

        int maxGap = 0;

        for (int i = 1; i < frets.size(); i++) {
            maxGap = Math.max(maxGap, frets.get(i) - frets.get(i - 1));
        }

        maxGap = Math.max(maxGap, frets.get(0) + 12 - frets.get(frets.size() - 1));

        int arc = 12 - maxGap;

        return arc + 1;
    }

    static void initNoteMap() {
        note.put("C", 0);
        note.put("C#", 1);
        note.put("D", 2);
        note.put("D#", 3);
        note.put("E", 4);
        note.put("F", 5);
        note.put("F#", 6);
        note.put("G", 7);
        note.put("G#", 8);
        note.put("A", 9);
        note.put("A#", 10);
        note.put("B", 11);
    }
}
