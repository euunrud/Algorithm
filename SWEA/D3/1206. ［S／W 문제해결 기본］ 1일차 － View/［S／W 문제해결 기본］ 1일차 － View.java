import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 10; i++) {
        	int n = Integer.parseInt(br.readLine());
            int[] arr= new int[n];
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            
            int num = 0;
            for(int j = 2; j < n - 2; j++) {
                int left = arr[j - 1] > arr[j - 2] ? arr[j - 1] : arr[j - 2];
                int right = arr[j + 1] > arr[j + 2] ? arr[j + 1] : arr[j + 2];
                int max = left > right ? left : right;
                if(arr[j] >max)
                    num += arr[j] - max;
            }
            System.out.println("#" + (i + 1) + " " + num);
        }
  }
}
