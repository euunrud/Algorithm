import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		PriorityQueue<Integer> pqueue = new PriorityQueue<>((o1, o2) -> {
			int f_abs = Math.abs(o1);
			int s_abs = Math.abs(o2);
			if (f_abs == s_abs) {
				return o1 > o2 ? 1 : -1;
			}else {
				return f_abs - s_abs;
			}
		});
		
		for(int i = 0; i < num; i++) {
			int n = sc.nextInt();
			if(n != 0) {
				pqueue.add(n);
			}else {
				if (pqueue.size() > 0)
					System.out.println(pqueue.poll());
				else 
					System.out.println("0");
			}
		}
	}
}