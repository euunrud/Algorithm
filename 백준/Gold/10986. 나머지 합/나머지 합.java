import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] nums = new long[n + 1];
        long[] cnt = new long[m];
        long sum = 0L;
       
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] + Long.parseLong(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++) {
            int num = (int)(nums[i] % m);
            cnt[num]++;
        }
        
        for(int c = 0; c < m; c++) {
            sum += cnt[c] * (cnt[c] - 1) / 2;
        }
        
        sum += cnt[0];
        System.out.println(sum);
    }
}