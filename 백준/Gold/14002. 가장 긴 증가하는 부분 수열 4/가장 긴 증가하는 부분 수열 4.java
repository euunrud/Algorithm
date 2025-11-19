import java.util.*;
import java.io.*;

class Main {
    static int[] memo, nums;
    static int n;
    static String[] words;
    static int dp(int idx) {
      if(idx == n)
        return 1;

      if(memo[idx] != 0)
        return memo[idx];
      
      int max = 0;
      String rs = "";
      for(int i = idx + 1; i <= n; i++) 
        if(nums[i] > nums[idx]) {
          int len = dp(i);
          String str = words[i];
          
          if(len > max) {
            max = len;
            rs = str;
          }
        }

      memo[idx] = max + 1;
      words[idx] = String.valueOf(nums[idx]).concat(" " + rs);
      //System.out.println("idx" + idx + " memo " + memo[idx] + " " + words[idx]);
      return memo[idx];
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
      
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n + 1];
        for(int i = 1; i <= n; i++)
          nums[i] = Integer.parseInt(st.nextToken());

        memo = new int[n + 1];
        words = new String[n  +1];
        words[n] = String.valueOf(nums[n]);
        int max = 1;
        String rs = String.valueOf(nums[1]);
        for(int i = 1; i <= n - max; i++) {
          int rslt = dp(i);
          if(rslt > max) {
            max = rslt;
            rs = words[i] ;
          }
        }
      
        System.out.println(max);
        System.out.println(rs);
  }
}
