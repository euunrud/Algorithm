import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = null;
    static StringBuilder sb = null;
    static Stack<Integer> stk = null;
    static Set<String> set = null;

    static String str = null;
    static int[] pair = null; 
    static boolean[] check = null;  

    public static void dfs(int deptNow, int dept) {
        if(deptNow == dept) {
            set.add(sb.toString());
            return;
        }

        char ch = str.charAt(deptNow);
        if(ch == '(') {
            check[deptNow] = true;
            dfs(deptNow+1, dept);
            check[deptNow] = false;
        }

        if(ch == ')' && check[pair[deptNow]]) { 
            check[deptNow] = true;  
            dfs(deptNow+1, dept);
            check[deptNow] = false;
        }else { 
            sb.append(ch);
            dfs(deptNow+1, dept);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        stk = new Stack<>();
        set = new HashSet<>();

        str = br.readLine();
        pair = new int[str.length()];
        check = new boolean[str.length()];

        int len = str.length();
        for(int i = 0; i < len; i++) {  
            char ch = str.charAt(i);
            if(ch == '(') {
                stk.push(i);
            }else if(ch == ')') {
                pair[i] = stk.peek(); 
                pair[stk.peek()] = i;  
                stk.pop();
            }
        }

        dfs(0, str.length());
        set.remove(str);  
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}