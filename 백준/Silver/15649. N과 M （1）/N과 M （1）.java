import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static void dfs(boolean[] vst, int idx, String sb) {
        if(idx >= m) {
            System.out.println(sb.toString());
            return;
        }
        
        for(int i = 1; i <= n; i++) {
            if(vst[i] == false) {
                vst[i] = true;
                String str = sb.toString();
                dfs(vst, idx + 1, str + " " + i);
                vst[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= n; i++) {
            boolean[] vst = new boolean[n + 1];
            vst[i] = true;
            String s = i + "";
            dfs(vst, 1, s);
            vst[i] = false;
        }
    }
}