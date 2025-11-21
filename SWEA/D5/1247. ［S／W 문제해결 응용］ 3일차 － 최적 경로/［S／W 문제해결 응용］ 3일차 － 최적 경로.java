import java.util.*;
import java.io.*;

class Solution
{
    static int n;
    static int[] arr;
    static int min;
    static boolean[] vst;
    static void dfs(int idx, int len, int dist) {
    	   if(len == n) {
              	int x = arr[idx * 2] - arr[2] > 0 ? arr[idx * 2] - arr[2] : arr[2] - arr[idx * 2];
              	int y = arr[idx * 2 + 1] - arr[3] > 0 ? arr[idx * 2 + 1] - arr[3] : arr[3] - arr[idx * 2 + 1];
               	int total = dist + x + y;
                if(total < min)
                    min = total;
               return;
           }
        
        	for(int i = 2; i < n + 2; i++) {
                if(vst[i] == false && i != idx) {
                	int x = arr[idx * 2] - arr[i * 2] > 0 ? arr[idx * 2] - arr[i * 2] : arr[i * 2] - arr[idx * 2];
              		int y = arr[idx * 2 + 1] - arr[i * 2 + 1] > 0 ? arr[idx * 2 + 1] - arr[i * 2 + 1] : arr[i * 2 + 1] - arr[idx * 2 + 1];
                   	vst[i] = true;
                    dfs(i, len + 1, dist + x + y);
                    vst[i] = false;
                }
             }
        
        return;
    }
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < num; i++) {
        	n = Integer.parseInt(br.readLine());
            arr= new int[n * 2 + 4];
            st = new StringTokenizer(br.readLine());
            min = 10000;
            for(int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            for(int j = 2; j < n + 2; j++) {
                vst = new boolean[n + 2];
                int idx = j * 2;
                int x = arr[idx] - arr[0] > 0 ? arr[idx] - arr[0] : arr[0] - arr[idx];
              	int y = arr[idx + 1] - arr[1] > 0 ? arr[idx + 1] - arr[1] : arr[1] - arr[idx + 1];
                vst[j] = true;
                dfs(j, 1, x + y);
            }
            
            System.out.println("#" + (i + 1) + " " + min);
        }
  }
}