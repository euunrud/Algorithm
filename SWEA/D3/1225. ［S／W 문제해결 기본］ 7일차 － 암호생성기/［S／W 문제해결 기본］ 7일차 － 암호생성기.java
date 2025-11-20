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
            System.out.print("#" + n);
            int[] arr= new int[8];
            st = new StringTokenizer(br.readLine());
            
            Queue<Integer> queue = new ArrayDeque<>();
            for(int j = 0; j < 8; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                queue.offer(arr[j]);
            }
            
           	int num = 1;
            while(!queue.isEmpty()) {
                int item = queue.poll() - num;
                if(item <= 0) {
                    queue.offer(0);
                    break;
                }else
               		queue.offer(item);
                num =  num % 5 + 1;
            }
            
            while(!queue.isEmpty())
            	System.out.print(" " + queue.poll());
       		System.out.println();
        }
  }
}