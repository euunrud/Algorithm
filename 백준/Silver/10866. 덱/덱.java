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

		int n;
		String s;
		StringTokenizer sn;
		int num = Integer.parseInt(br.readLine());
		int[] deque = new int[num];

		int index1 = 0;
		int index2 = 0;
		for(int i = 0; i < num; i++) {
			sn = new StringTokenizer(br.readLine());
			s = sn.nextToken();

			//System.out.println("idx - " + index1 + ", " + index2);
			if(s.equals("push_front")) {
				n = Integer.parseInt(sn.nextToken());
				if (index1 == 0) {
					for ( int j = index2; j > 0; j--) {
						deque[j] = deque[j - 1];
					}
					deque[0] = n;

					index2++;
				}else {
					index1 -= 1;
					deque[index1] = n;
				}
			}else if(s.equals("push_back")) {
				n = Integer.parseInt(sn.nextToken());
				deque[index2] = n;
				index2++;
			} else if (s.equals("pop_front")) {
				if(index2 != index1) { //안비었다는 것.
					bw.write(deque[index1] + "\n");
					index1++;
				}else {
					bw.write(-1 + "\n");
				}
			} else if (s.equals("pop_back")) {
				if(index2 != index1) {
					bw.write(deque[index2 - 1] + "\n");
					index2--;
				}else {
					bw.write(-1 + "\n");
				}
			} else if (s.equals("size")) {
				bw.write(index2 - index1 + "\n");
			} else if (s.equals("empty")) {
				if (index1 == index2) {
					bw.write(1 + "\n");
				}else {
					bw.write(0 + "\n");
				}
			}else if (s.equals("front")) {
				if (index1 != index2) {
					bw.write(deque[index1] + "\n");
				}else {
					bw.write(-1 + "\n");
				}
			}else if (s.equals("back")) {
				if (index1 != index2) {
					bw.write(deque[index2 - 1] + "\n");
				}else {
					bw.write(-1 + "\n");
				}
			}
			if(index2 < index1) {
				index2 = index1;
			}
			//System.out.println("s:" + s + "i1 - " + index1 + ", i2 -" + index2);
		}

		bw.flush();
		bw.close();
	}
}
