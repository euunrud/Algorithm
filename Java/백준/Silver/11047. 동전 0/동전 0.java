import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
        	a[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        int coin = 1;
        while(k > 0) {
        	for(int i = n - 1; i >= 0; i--) {
        		if(a[i] <= k) {
        			coin = a[i];
        			break;
        		}
        	}
        	
        	cnt += k / coin;
        	k %= coin;
        }
        
        System.out.println(cnt);
	}
}
