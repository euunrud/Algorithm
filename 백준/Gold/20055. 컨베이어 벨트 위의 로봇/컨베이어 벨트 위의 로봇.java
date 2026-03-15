import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] ch = new boolean[2 * n];
        int[] cbb = new int[2 * n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * n; i++)
            cbb[i] = Integer.parseInt(st.nextToken());
            
        int p1 = 0;
        int p2 = n - 1;
        int cnt = 0;
        int num = 0;
        while(cnt < k) {
            num++;
            p1 = (p1 + 2 * n - 1) % (2 * n);
            p2 = (p2 + 2 * n - 1) % (2 * n);
            
            int c = 0;
            for(int i = p2; i >= 0; i--) {
                if(i == p1 - 1) break;
                c++;
                int next = (i + 1) % (2 * n);
                if(ch[p2] ==true){
                    ch[p2] = false;
                }
                if(ch[i] == true && ch[next] == false && cbb[next] > 0) {
                    ch[i] = false;
                    if(next != p2)
                        ch[next] = true;
                    cbb[next]--;
                    if(cbb[next] == 0) cnt++;
                }
            }
            if(c < n) {
                for(int i = 2 * n - 1; i >= p1; i--) {
                    if(c == n) break;
                    c++;
                    int next = (i + 1) % (2 * n);
                    
                    if(ch[i] == true && ch[next] == false && cbb[next] > 0) {
                        ch[i] = false;
                        if(next != p2)
                            ch[next] = true;
                        cbb[next]--;
                        if(cbb[next] == 0) cnt++;
                    }
                }
            }
            
            if(cbb[p1] >= 1) {
                ch[p1] = true;
                cbb[p1]--;
                if(cbb[p1] == 0) cnt++;
            }
        }
        
        System.out.println(num);
    }
}