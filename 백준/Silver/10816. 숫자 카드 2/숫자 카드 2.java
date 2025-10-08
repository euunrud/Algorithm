
import java.io.*;
import java.util.*;

class Main {
    static int[] nums;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++)
		    nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
	
		int m = Integer.parseInt(br.readLine());
		int[] mNums = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
		    int num = Integer.parseInt(st.nextToken());
		    int a = lBinary(num);
		    int b = rBinary(num);
    	    sb.append(b - a).append(' ');
		}
		System.out.print(sb);
    }
    
    static int lBinary(int n) {
        int left = 0;
        int right = nums.length;
        
        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= n)
                right = mid;
            else 
                left = mid + 1;
        }
        return left;
    }
    
     static int rBinary(int n) {
        int left = 0;
        int right = nums.length;
         
        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > n)
                right = mid;
            else 
                left = mid + 1;
        }
        return left;
    }
}