import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(trees);
        long left = 0;
        long right = trees[n - 1];
        long height = right;
        
        while(left <= right) {
            long mid = (long)(left + right) / 2;
            long sum = 0L;
            for(long t: trees)
                if(mid < t)
                    sum += t - mid;
            
            if(sum >= m){
                height = mid;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        
        System.out.println(height);
    }
}