import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
        }
        
        long l = 0;
        long r = (long)min * m;
        while(l < r) {
            long mid = (l + r) / 2;
            long num = 0;
            for(int i = 0; i < n && num <= m; i++)
                num += mid / arr[i];
                
            if(num < m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.print(l);
    }
}