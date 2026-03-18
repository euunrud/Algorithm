import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] vst = new int[100001];
        Arrays.fill(vst, 100001);
        
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{n, 0});
        vst[n] = 0;
        
        while(!que.isEmpty()){
            int[] q = que.poll();
            if(q[0] == k) break;
            
            if(q[0] * 2 < 100001 && vst[q[0] * 2] > q[1]) {
                que.offer(new int[]{q[0] * 2, q[1]});
                vst[q[0] * 2] = q[1];
            }
            if(q[0] - 1 >= 0 && vst[q[0] - 1] > q[1] + 1) {
                que.offer(new int[]{q[0] - 1, q[1] + 1});
                vst[q[0] - 1] = q[1] + 1;
            }
            if(q[0] + 1 < 100001 && vst[q[0] + 1] > q[1] + 1) {
                que.offer(new int[]{q[0] + 1, q[1] + 1});
                vst[q[0] + 1] = q[1] + 1;
            }
        }
        System.out.print(vst[k]);
    }
}