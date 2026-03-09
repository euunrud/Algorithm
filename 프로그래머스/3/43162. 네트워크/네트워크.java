import java.util.*;

class Solution {
    boolean[] com;
    List<Integer>[] list;
    public void dfs(int idx) {
        for(int i = 0; i < list[idx].size(); i++) {
            if(com[list[idx].get(i)] == false) {
                com[list[idx].get(i)] = true;
                dfs(list[idx].get(i));
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int len = computers.length;
        com = new boolean[len];
        list = new ArrayList[len];
        for(int i = 0; i < len; i++) 
            list[i] = new ArrayList<>();
        
        for(int i = 0; i < len; i++) 
            for(int j = 0; j < len; j++)
                if(computers[i][j] == 1 && i != j)
                    list[i].add(j);
        
        int cnt = 0;
        for(int i = 0; i < len; i++)
            if(com[i] == false) {
                cnt++;
                com[i] = true;
                dfs(i);
            }
        
        return cnt;
    }
}