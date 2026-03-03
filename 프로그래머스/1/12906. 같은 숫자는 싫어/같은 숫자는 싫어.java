import java.util.*;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> li = new ArrayList<>();
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                li.add(arr[i]);
            } else{
                continue;
            }
        }
        li.add(arr[arr.length-1]);
        
        int[] answer = new int[li.size()];
        
        for(int i=0;i<li.size();i++){
            answer[i]=li.get(i);
        }
        return answer;
    }
}