import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] f = new int[n+1];
		f[1] = f[2] = 1;
		for(int i = 3; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		System.out.println(f[n] + " " + (n - 2));
	}
}