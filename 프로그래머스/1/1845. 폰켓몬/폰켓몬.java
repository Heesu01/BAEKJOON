import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            set.add(i);
        }
        int pick = nums.length/2;
        answer= Math.min(pick,set.size());
        return answer;
    }
}