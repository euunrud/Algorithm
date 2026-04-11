import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static int[] memo;
    static String[] srr;
    
    static int dp(int idx) {
        if(memo[idx] != 0) 
            return memo[idx];
        
        int max = 0;
        for(int i = idx + 1; i < n; i++) {
            if(arr[i] > arr[idx]) {
                int a = dp(i);
                
                if(a > max) {
                    max = a;
                    srr[idx] = arr[idx] + " " + srr[i];
                }
                
            }
        }
        
        if(srr[idx] == null) srr[idx] = arr[idx] + "";
        memo[idx] = max + 1;
        
        return memo[idx];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        memo = new int[n];
        srr = new String[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i < n; i++) {
            int rslt = dp(i);
            if(rslt > max) {
                max = rslt;
                maxIdx = i;
            }
        }
        
        System.out.println(max);
        System.out.print(srr[maxIdx]);
    }
}