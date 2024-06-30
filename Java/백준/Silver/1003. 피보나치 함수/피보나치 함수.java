import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
		static long[][] fn = new long[41][2];

	public static void fibo(int n) {
		fn[0][0] = 1;
		fn[0][1] = 0;
		fn[1][0] = 0;
		fn[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			fn[i][0] = fn[i - 1][0] + fn[i - 2][0];
			fn[i][1] = fn[i - 1][1] + fn[i - 2][1];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		int[] nums = new int[num];
		for(int i = 0; i < num; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			fibo(nums[i]);
			bw.write(fn[nums[i]][0] + " " + fn[nums[i]][1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}
