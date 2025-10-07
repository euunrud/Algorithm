import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] nums = new int[m - n + 1];
		int idx = 0;
		int sum = 0;
		for(int i = n; i <= m; i++) {
		    if(isPrime(i)) {
		        nums[idx++] = i;
		        sum += i;
		    }
		}
		
		if(nums[0] != 0){
    		System.out.println(sum);
    		System.out.println(nums[0]);
		}else {
		    System.out.println("-1");
		}
    }
    
    static boolean isPrime(int n) {
        if (n < 2) return false; 

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}