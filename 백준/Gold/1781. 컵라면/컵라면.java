import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] problem = new int[n][2];
        StringTokenizer st;
        for(int i  = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            problem[i][0] = Integer.parseInt(st.nextToken());
            problem[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(problem, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int idx = 1;
        queue.offer(problem[0]);
        while(idx < n) {
            int[] a = problem[idx];
            queue.offer(a);
            if(queue.size() > a[0]) 
                queue.poll();
            idx++;
        }
        
        int rslt = 0;
        while(!queue.isEmpty()) 
            rslt += queue.poll()[1];
        System.out.println(rslt);
    }
}