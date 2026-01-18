import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        
        int l = max;
        int r = sum;
        int mid;
        while(l < r) {
            mid = (l + r) / 2;
            int cnt = 0;
            
            for(int i = 0; i < n; i++) {
                int num = 0;
                cnt++;
                while(i < n && num + arr[i] <= mid)
                    num += arr[i++];
                i--;
            }
            
            if(cnt > m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        System.out.println(l);
    }
}