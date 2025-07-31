import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();               
        Map<String, List<int[]>> songMap = new HashMap<>();            

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];


            if (genreMap.containsKey(genre)) {
                genreMap.put(genre, genreMap.get(genre) + play);
            } else {
                genreMap.put(genre, play);
            }


            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new ArrayList<>());
            }
            songMap.get(genre).add(new int[]{i, play}); 
        }

        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        Collections.sort(sortedGenres, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return genreMap.get(b) - genreMap.get(a);
            }
        });

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> songs = songMap.get(genre);

            Collections.sort(songs, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (b[1] != a[1]) {
                        return b[1] - a[1]; 
                    } else {
                        return a[0] - b[0]; 
                    }
                }
            });

            result.add(songs.get(0)[0]); 
            if (songs.size() > 1) {
                result.add(songs.get(1)[0]); 
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
