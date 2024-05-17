import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input;
		StringTokenizer sn;
		int num = Integer.parseInt(br.readLine());
		int[] cnt = new int[2];

		for(int i = 0; i < num; i++) {
			cnt = new int[] {0, 0};
			sn = new StringTokenizer(br.readLine());
			input = sn.nextToken();
			for(String s : input.split("")) {
				if(s.equals("(")) {
					cnt[0]++;
				}else if(s.equals(")")) {
					cnt[1]++;
				}
				if(cnt[1] > cnt[0]) {
					bw.write("NO\n");
					break;
				}
			}
			if(cnt[1] <= cnt[0]) {
				if (cnt[0] != cnt[1]) {
					bw.write("NO\n");
				}else {
					bw.write("YES\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}