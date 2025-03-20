import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] S = new int[n];
        
        for(int i = 0; i < n; i++) {
        	S[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(S);
        for(int i = 0; i< n; i++) {
        	System.out.println(S[i]);
        }
	}

}