class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] v = new boolean[n];
        int cnt=0;
        for (int i=0;i<n;i++){
            if(!v[i]) {
                dfs(i,v,computers,n);
                cnt++;
            }
        }
        return cnt;
    }
    
    public static void dfs(int node, boolean[] v, int[][] computers, int n){
        v[node]=true;
        for(int i=0;i<n;i++){
            if(!v[i] && computers[node][i]==1){
                dfs(i, v, computers, n);
            }
        }
    }
}