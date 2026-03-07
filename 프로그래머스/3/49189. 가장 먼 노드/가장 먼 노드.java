import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[][] node = new int[n + 1][2];
        List<Integer>[] list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        node[1][1] = -1;
        node[0][1] = -1;
        for(int i = 0; i < list[1].size(); i++) {
            int num = list[1].get(i);
            que.offer(num);
            node[num] = new int[]{num, 1};
        }
        
        while(!que.isEmpty()) {
            int q = que.poll();
            for(int i = 0; i < list[q].size(); i++) {
                int num = list[q].get(i);
                if(node[num][1] != 0) continue;
                que.offer(num);
                node[num] = new int[]{num, node[q][1] + 1};
            }
        }
        
        Arrays.sort(node, (a, b) -> b[1] - a[1]);
        int cnt = 0;
        for(int i = 0; i < node.length; i++) {
            if(node[i][1] != node[0][1]) break;
            cnt++;
        }
        return cnt;
    }
}