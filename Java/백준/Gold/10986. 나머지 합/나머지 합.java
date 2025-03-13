import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] S = new long[n + 1];
		long[] cnt = new long[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n + 1; i++) {
			if(i == 1) {
				S[i] = Long.parseLong(st.nextToken());
			}else {
				S[i] = S[i - 1] + Long.parseLong(st.nextToken());
			}
		}
		
		for(int i = 1; i < n + 1; i++) {
			int num = (int)(S[i] % m);
			cnt[num]++;
		}
		Long rslt = 0L;
		rslt += cnt[0];
		for(int i = 0; i < m; i++) {
			Long num = cnt[i];
			rslt += num * (num - 1) / 2;
		}
		System.out.println(rslt);
	}
}