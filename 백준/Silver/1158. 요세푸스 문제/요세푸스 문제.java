import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		String[] tokens = input.split(" ");
		int num = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);

		List<Integer> list = new ArrayList<>();
		List<Integer> rslt = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			list.add(i);
		}

		int idx = k - 1;
		while(num > 1) {
			rslt.add(list.get(idx));
			list.remove(idx);

			num--;
			if(idx + k > num) {
				idx = idx + k - num - 1;
				while ( idx >= num) {
					idx = idx - num;
				}
			}else {
				idx += k - 1;
			}
		}

		rslt.add(list.get(0));
		StringBuilder resultString = new StringBuilder("<");
		for (int i = 0; i < rslt.size(); i++) {
			resultString.append(rslt.get(i));
			if (i != rslt.size() - 1) {
				resultString.append(", ");
			}
		}
		resultString.append(">");

		System.out.println(resultString.toString());
	}
}
