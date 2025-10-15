import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<ArrayList<Integer>> graph = new ArrayList<>();
        
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        
        int w = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        
        int cnt = 0;
        for(int i = 1; i <=n; i++)
            if(graph.get(i).size() == 1 && i != 1) 
                cnt++;
        
        if(n == 1)
            System.out.println(w);
        else
            System.out.println((double) w / cnt);
    }
}