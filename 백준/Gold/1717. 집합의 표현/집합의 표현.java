import java.util.*;
import java.io.*;

class Main {
    static int[] parent;
    static int n, m;
    static boolean check(int a, int b) {
        int c = find(a);
        int d = find(b);
        return c == d;
    }
    
    static int find(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        int c = find(a);
        int d = find(b);
        parent[d] = c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++)
            parent[i] = i;
            
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(k == 0) {
                union(a, b);
            }else {
                boolean ch = check(a, b);
                if(ch) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}