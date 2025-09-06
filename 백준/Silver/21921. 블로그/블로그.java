
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[] vs = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        vs[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++) {
            vs[i] = vs[i - 1] + Integer.parseInt(st.nextToken());
            //System.out.println("i - " + i + "  vs[i] " + vs[i]); 
        }
        
        int[] sum = new int[n];
        int cnt = 0;
        sum[0] = vs[x - 1];
        int max = sum[0];
        for(int i = 1; i < n - x + 1; i++) {
            sum[i] = vs[i + x - 1] - vs[i - 1];
            //System.out.println("i - " + i + "  sum[i] " + sum[i]); 
            if(sum[i] > max) {
                max = sum[i];
            }
        }
    
        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        
        for(int i = 0; i < n - x + 1; i++) {
            if(sum[i] == max) {
                cnt++;
            }
        }
    
        System.out.print(max + "\n" + cnt);
     }
}