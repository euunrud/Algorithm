
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int sum = 0;
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        while (start < end) {
        	//System.out.println("i - " + i + "s-" + arr[start] +", e - " + arr[end] + " , n - " + num);
        	if(arr[start] + arr[end] == m) {
	       		//System.out.println("3");
	       		//System.out.println("s-" + arr[start] +", e - " + arr[end]);
	       		sum++;
	       		start++;
	       	}else if(arr[start] + arr[end] > m) {
	       		//System.out.println("4");
	       		end--;
	       	}else if(arr[start] + arr[end] < m) {
	       		//System.out.println("5");
	       		start++;
	       	}
	   }
        
        System.out.print(sum);
	}
}
