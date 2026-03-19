import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        long rslt = Long.MAX_VALUE;
        int p1= 0; int p2 = n - 1;
        long min = Long.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int right = n - 1;
            int left = i + 1;
            int mid = n;
            int minIdx = n;
            
            while(left <= right) {
                mid = (left + right) / 2;
                long sum = Math.abs(arr[i] + arr[mid]);
                //System.out.println("l " +left + " r " + right + " m " + mid + " sum " + sum + " min " + min);
                if(sum < min) {
                    min = sum;
                    minIdx = mid;
                }
                if(mid + 1 < n && Math.abs(arr[mid + 1] + arr[i]) <= Math.abs(arr[mid - 1] + arr[i]))
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            
            if(rslt > min) {
                rslt = min;
                p1 = i;
                p2 = minIdx;
            }
        }
        
        System.out.print(arr[p1] + " " + arr[p2]);
    }
}