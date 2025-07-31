import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> songMap = new HashMap<>();
        
        for (int i =0; i<genres.length; i++){
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i],0)+ plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>());
            songMap.get(genres[i]).add(new int[]{i, plays[i]}); 
        }
        
        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        sortedGenres.sort((a, b) -> genreMap.get(b) - genreMap.get(a));
        
        
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = songMap.get(genre);
            songs.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                return a[0] - b[0]; 
            });

            result.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                result.add(songs.get(1)[0]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}