import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		int[] tile = new int[1001];

		tile[1] = 1;
		tile[2] = 2;
		for (int i = 3; i <= num; i++) {
			tile[i] = (tile[i - 1] + tile[i - 2]) % 10007;
		}

		bw.write(tile[num] + "\n");
		bw.flush();
		bw.close();
	}
}
