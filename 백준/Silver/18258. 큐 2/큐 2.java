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
		int index1 = 0;
		int index2 = 0;
		for(int i = 0; i < num; i++) {
			sn = new StringTokenizer(br.readLine());
			s = sn.nextToken();
			if(s.equals("push")) {
				n = Integer.parseInt(sn.nextToken());
				stack[index2] = n;
				index2++;
			} else if (s.equals("size")) {
				bw.write(index2 - index1 + "\n");
			} else if (s.equals("pop")) {
				if(index2 != index1) {
					bw.write(stack[index1] + "\n");
					index1++;
				}else {
					bw.write(-1 + "\n");
				}
			} else if (s.equals("empty")) {
				if (index1 == index2) {
					bw.write(1 + "\n");
				}else {
					bw.write(0 + "\n");
				}
			}else if (s.equals("front")) {
				if (index1 != index2) {
					bw.write(stack[index1] + "\n");
				}else {
					bw.write(-1 + "\n");
				}
			}else if (s.equals("back")) {
				if (index1 != index2) {
					bw.write(stack[index2 - 1] + "\n");
				}else {
					bw.write(-1 + "\n");
				}
			}
			//System.out.println("s:" + s + "i1 - " + index1 + ", i2 -" + index2);
		}

		bw.flush();
		bw.close();
	}
}