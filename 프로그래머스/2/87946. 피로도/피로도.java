class Solution {
    int len;
    int rslt = 0;
    void dfs(int k, int cnt, int[][] dungeons, boolean[] vst) {
        rslt = Math.max(rslt, cnt);
        for(int i = 0; i < len; i++) {
            if(vst[i] == true) continue;
            if(dungeons[i][0] <= k) {
                vst[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons, vst);
                vst[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length; 
        boolean[] vst = new boolean[len];
        
        dfs(k, 0, dungeons, vst);
        return rslt;
    }
}