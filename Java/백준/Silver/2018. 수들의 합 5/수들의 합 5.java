
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int total = 0;
        for(int i = 1; i < n + 1; i++) {
        	total = 0;
        	total += i;
        	for (int j = i + 1; j < n + 1; j++) {
        		total += j;
        		if(total == n) {
        			sum++;
        			break;
        		}else if( total > n) {
        			break;
        		}
        	}
        }
        System.out.print(sum);
	}
}