import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= num; i++) {
			queue.add(i);
		}
		
		while(num > 0) {  //num 쓸필요 없이 queue.size()를 통해 큐에 있는 데이터 개수 알 수 있다. 
			int fn = queue.poll();
			if(num == 1) {
				System.out.println(fn);
				break;
			}
			int sn = queue.poll();
			queue.add(sn);
			num--;
		}
	}

}