import java.io.*;
import java.util.*;

class Main {
    static List<ArrayList<Integer>> list;
    static int a, b;
    static int min;
    static boolean[] ch;
    static void DFS(int p, int dt) {
        if(ch[p] == true) 
            return;
        ch[p] = true;
        
        if(p == b) {
            if(dt < min)
                min = dt;
            return;
        }
        
        for(int i = 0; i < list.get(p).size(); i++)
            DFS(list.get(p).get(i), dt + 1);
       
        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        min = n + 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        int num = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        ch = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            list.get(p1).add(p2);
            list.get(p2).add(p1);
        }
        
       DFS(a, 0);
       if(min > n) {
           min = -1;
       }
       System.out.println(min);
    }
}
