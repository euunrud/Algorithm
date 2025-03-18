import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
        	int n1 = Math.abs(o1);
        	int n2 = Math.abs(o2);
        	
        	if(n1 == n2) {
        		return o1 > o2 ? 1 : -1; //음수 반환시 우선순위 높음
        	} else {
        		return n1 - n2; //n1 이 더 큰 숫자일 경우 양수반환도어 우선순위 낮음.
        	}
        });

        for(int i = 0; i < n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(num != 0) {
        		que.add(num);
        	}else {
        		if(que.isEmpty()) {
        			bw.write("0\n");
        		}else {
        			bw.write(que.poll() + "\n");
        		}	
        	}
        }
        
        bw.flush();
        bw.close();
        
	}
}
