import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int f1, f2, answer = 0;

		int[][] arr = new int[n + 1][n + 1];
		boolean[] invite = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			f1 = Integer.parseInt(st.nextToken());
			f2 = Integer.parseInt(st.nextToken());
			arr[f1][f2] = 1;
			arr[f2][f1] = 1;
		}

		for (int i = 2; i < n + 1; i++) {
			if (arr[1][i] == 1) {
				if (!invite[i]) {
					answer++;
					invite[i] = true;
				}
				for (int j = 2; j < n + 1; j++) {
					if (arr[i][j] == 1 && !invite[j]) {
						answer++;
						invite[j] = true;
					}
				}
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
