import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     int n = Integer.parseInt(st.nextToken());
	     int l = Integer.parseInt(st.nextToken());

	     Deque<Node> deq = new LinkedList<>();
	     st = new StringTokenizer(br.readLine());
	     
	     for(int i = 1; i <= n; i++) {
	    	 int num = Integer.parseInt(st.nextToken());

	    	 while(!deq.isEmpty() && deq.getLast().value > num) {
		    	 //System.out.println("num " + num +", / " + deq.getLast().value);
	    		 deq.removeLast();
	    	 }
	    	 deq.addLast(new Node(i, num));
	    	 
	    	 if(deq.getFirst().index <= i - l) {
	    		 deq.removeFirst();
	    	 }
	    	 //System.out.println("-- " + deq.getFirst().value);
	    	 bw.append(deq.getFirst().value + " ");
	    	 
	     }
	     bw.flush();
	     bw.close();
	}
	
	public static class Node {
		int index;
		int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

}