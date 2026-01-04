import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static int[][] edges;
    static int[] parent;
    static int find(int n) {
        if(parent[n] == n)
            return parent[n];
        return parent[n] = find(parent[n]);
    }
    
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new int[e][3];
        parent = new int[v + 1];
        
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{a, b, c};
        }
        
        for(int i = 1; i <= v; i++)
            parent[i] = i;
            
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        
        int rslt = 0;
        int cnt = 1;
        for(int i = 0; i < e; i++) {
            if(union(edges[i][0], edges[i][1])) {
                rslt += edges[i][2];
                cnt++;
            }
            if(cnt == v)
                break;
        }
        
        System.out.print(rslt);
	}
}