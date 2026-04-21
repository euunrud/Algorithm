import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int idx, int sum, String s, int last) {
        if(idx > last) {
            if(sum == 0)
                sb.append(s + "\n");
            return;
        }
        
        String s1 = s + "-" + idx;
        String s2 = s + "+" + idx;
        String s3 = s + " " + idx;
        int num = (idx - 1) * 10 + idx;
        if(s.length() > 2) {
            if(s.charAt(s.length() - 2) == '-') {
                sum += (idx - 1);
                dfs(idx + 1, sum - num, s3, last);
                sum -= (idx - 1);
            } else if(s.charAt(s.length() - 2) == '+') {
                sum -= (idx - 1);
                dfs(idx + 1, sum + num, s3, last);
                sum += (idx - 1);
            }
        } else {
            sum -= (idx - 1);
            dfs(idx + 1, sum + num, s3, last);
            sum += (idx - 1);
        }
        dfs(idx + 1, sum + idx, s2, last);
        dfs(idx + 1, sum - idx, s1, last);
        
        return;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            String s = "1";
            int sum = 1;
            int idx = 2;
            
            dfs(idx, sum, s, a);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}