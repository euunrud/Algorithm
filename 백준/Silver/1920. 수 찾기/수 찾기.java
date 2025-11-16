import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());
            
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums2 = new int[m];
        for(int i = 0; i < m; i++)
            nums2[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(nums);
        
        for(int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            int num = nums2[i];
            int rslt = 0;
            while(left < right) {
                int mid = (left + right) / 2;
                if(num > nums[mid])
                    left = mid + 1;
                else 
                    right = mid;
            }
            if(nums[left] == num)
                    rslt = 1;
            System.out.println(rslt);
        }
    }
}