import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static String[] cdd;
    static Set<String> set;
    static void dfs(int idx, String sb, int mn, int jn) {
        if(sb.length() == l){
            if(jn > 1 && mn > 0)
                System.out.println(sb.toString());
            return;
        }
        
        if(idx >= c) return;
        boolean ch = false;
        if(set.contains(cdd[idx]))
            ch = true;
        
        if(ch) mn++;
        else jn++;
        dfs(idx + 1, sb + cdd[idx], mn, jn);
        
        if(ch) mn--;
        else jn--;
        dfs(idx + 1, sb, mn, jn);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cdd = new String[c];
        st = new StringTokenizer(br.readLine());
        
        set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        
        for(int i = 0; i < c; i++)
            cdd[i] = st.nextToken();
            
        Arrays.sort(cdd);
        dfs(0, "", 0, 0);
    }
}