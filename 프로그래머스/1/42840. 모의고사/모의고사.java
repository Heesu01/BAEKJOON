import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int one_score=0;
        int two_score=0;
        int three_score=0;
        
        for(int i=0;i<answers.length;i++){
            if(one[i%5]==answers[i]){
                one_score+=1;
            } 
            if (two[i%8]==answers[i]) {
                two_score+=1;
            }
            if (three[i%10]==answers[i]){
                three_score +=1;
            }
        }
        int max = Math.max(three_score,Math.max(one_score,two_score));
        List<Integer> li = new ArrayList<>();
        if(max==one_score) li.add(1);
        if(max==two_score) li.add(2);
        if(max==three_score) li.add(3);
        
        int[] answer = new int[li.size()];
        for(int i=0;i<li.size();i++){
            answer[i]=li.get(i);
        }
        
        return answer;
    }
}