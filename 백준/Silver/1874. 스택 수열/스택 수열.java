import java.util.Scanner;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i =0; i< n; i++) {
			A[i] = sc.nextInt();
        }
		Stack<Integer> st = new Stack<>();
		StringBuffer sb = new StringBuffer();
		boolean f = true; //이것도 나중에 넣음...
		int num = 1;
		
		for(int i =0; i < A.length; i++) {  //이게 n이 아니라 이거인 이유는 pop하면 그만큼 돌 개수가 안되니까? 인듯
			if (A[i] >= num) {
				while (num <= A[i]) { 
					st.push(num++);
					sb.append("+\n");
				}
				st.pop();
				sb.append("-\n");
			}
			else {
				int pnum = st.pop();
				if(pnum > A[i]) {  //조건 주의... 스택에 위에 수가 남아있는데 A[i]요구 값이 다르면 NO가 뜨는 것
//					sb.delete(0,i);
//					sb.append("NO/n"); //굳이 이렇게 할 필요 없다. 그냥 boolean이용하면 훨씬 편함.
					f = false;
					break;
				}else {
					sb.append("-\n");
				}
			}
		}
		if (f == true)
			System.out.print(sb.toString());
		else 
			System.out.println("NO");
	}
}