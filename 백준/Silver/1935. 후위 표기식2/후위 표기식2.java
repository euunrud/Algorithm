
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Double> stack = new Stack<>();
		int num = Integer.parseInt(br.readLine());

		String[] list = new String[num];
		Double[] nums = new Double[num];
		String input = br.readLine();

		for (int i = 0; i < num; i++) {
			nums[i] = Double.parseDouble(br.readLine());
		}

		int index = 0;
		Double rslt = 0.0;
		for(String s : input.split("")) {
			//System.out.println("s - " + s);
			if (s.equals("+")) {
				rslt = stack.pop() + stack.pop();
				stack.push(rslt);
			}else if (s.equals("-")) {
				Double temp = stack.pop();
				rslt = stack.pop() - temp;
				stack.push(rslt);
			}else if (s.equals("*")) {
				rslt = stack.pop() * stack.pop();
				stack.push(rslt);
			}else if (s.equals("/")) {
				Double temp = stack.pop();
				rslt = stack.pop() / temp;
				stack.push(rslt);
			}else{
				int n = -1;
				for(int i = 0; i < list.length; i++) {
					if(s.equals(list[i])) {
						n = i;
						break;
					}
				}
				if(n == -1) {
					stack.push((Double)nums[index]);
					list[index] = s;
					index++;
				}else {
					stack.push((Double)nums[n]);
				}
			}
			//System.out.println(stack.toString());
		}
		String result = String.format("%.2f",stack.pop());
		bw.write(result);

		bw.flush();
		bw.close();
	}
}
