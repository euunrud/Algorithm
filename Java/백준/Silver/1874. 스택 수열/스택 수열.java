
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
	    int n = Integer.parseInt(br.readLine());

	    Stack<Integer> s = new Stack<>();
	    int[] A = new int[n + 1];
	    int num = 1;
	    int idx = 1;
	    boolean result = true;
	    for(int i =1; i < n + 1; i++) {
	    	A[i] = Integer.parseInt(br.readLine());
	    }
	    while(num <= n || idx <= n) {
    		//System.out.println(" num - " + num + " idx - " + idx);
	    	if(!s.isEmpty() && s.peek() == A[idx]) {
	    		while(!s.isEmpty() && s.peek() == A[idx]) {
		    		//System.out.println("A[idx] - "+ A[idx] + "  --");
		    		s.pop();
		    		idx++;
		    		sb.append("-\n");
	    		}
	    	}else if (A[idx] >= num) {
	    		//System.out.println("num - "+ num + "  ++");
	    		s.push(num);
	    		num++;
	    		sb.append("+\n");
	    	}else {
	    		result = false;
	    		break;
	    	}
	    }
	    
	    if(result) {
	    	System.out.println(sb.toString());
	    } else {
	    	System.out.println("NO");
	    }
	}
}
