import java.io.*;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		String s;
		StringTokenizer sn;
		int num = Integer.parseInt(br.readLine());
		int[] stack = new int[num];
		int index = 0;
		for(int i = 0; i < num; i++) {
			sn = new StringTokenizer(br.readLine());
			s = sn.nextToken();
			if(s.equals("push")) {
				n = Integer.parseInt(sn.nextToken());
				stack[index] = n;
				index++;
			} else if (s.equals("top")) {
				if (index != 0) {
					bw.write(stack[index - 1] + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			} else if (s.equals("size")) {
				bw.write(index + "\n");
			} else if (s.equals("pop")) {
				if(index != 0) {
					bw.write(stack[index - 1] + "\n");
					index--;
				}else {
					bw.write(-1 + "\n");
				}
			} else if (s.equals("empty")) {
				if (index == 0) {
					bw.write(1 + "\n");
				}else {
					bw.write(0 + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
	}
}