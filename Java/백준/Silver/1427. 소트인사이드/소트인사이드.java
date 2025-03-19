import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] count = new int[10];
		
		while(n!=0) {
			count[n%10] +=1;
			n /= 10;
		}

		for(int i=9; i>=0; i--) {
			for(int j = 0; j<count[i]; j++)
				System.out.print(i);
		}
		
	}

}
