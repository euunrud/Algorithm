import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 0;
        int sum = 1;
        int total = 0;
        while (end != n) {
        	if(total == n) {
        		sum++;
        		total -= start;
        		start++;
        	} else if ( total < n) {
        		end++;
        		total += end;
        	} else {
        		total -= start;
        		start++;
        	}
        }
        System.out.print(sum);
	}
}